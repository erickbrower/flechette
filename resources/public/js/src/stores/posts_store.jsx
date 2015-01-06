var AppDispatcher = require('../dispatcher/AppDispatcher'),
  EventEmitter = require('events').EventEmitter,
  PostConstants = require('../constants/post_constants'),
  $ = require('jquery'),
  _ = require('underscore');


var _posts = [],
  _count = 0;

function listPosts(options, callback) {
  $.get('/api/posts', options)
    .done(function(response) {
      _posts = response.data;
      _count = response.count;
    })
    .fail(function() {
      //show oops error message
    })
    .always(function() {
      if (callback) {
        callback();
      }
    });
}

function showPost(id, callback) {
  $.get('/api/posts/' + id.toString())
    .done(function(response) {})
    .fail(function() {
      //show error message
    })
    .always(function() {
      if (callback) {
        callback();
      }
    });
}


var PostStore = _.extend({}, EventEmitter.prototype, {
  getPosts: function() {
    return _posts;
  },
  addChangeListener: function(callback) {
    this.on('change', callback);
  },
  removeChangeListener: function(callback) {
    this.removeListener('change', callback);
  },
  emitChange: function() {
    this.emit('change');
  }
});

AppDispatcher.register(function(payload) {
  var action = payload.action;
  var actions = {};
  actions[PostConstants.POST_LIST] = function(action, callback) {
    listPosts(action.data, callback);
  };
  actions[PostConstants.POST_SHOW] = function(action) {
    showPost(
  }
});

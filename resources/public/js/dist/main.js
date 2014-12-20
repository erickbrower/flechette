var React = require('react'),
  Backbone = require('backbone'),
  Router = require('./router.jsx'),
  IndexContentView = require('./views/index_content_view.jsx');

Backbone.$ = $ = require('jquery');

var router = new Router();

router.on('route:index', function() {
  $.get('/api/posts')
    .done(function(response) {
      debugger;
      React.renderComponent(
        React.createElement(IndexContentView, {posts: response.data, count: response.count}), 
        document.getElementById('main-content'));
    });
});

Backbone.history.start();

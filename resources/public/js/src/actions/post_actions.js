var AppDispatcher = require('../dispatcher/app_dispatcher.jsx'),
  PostConstants = require('../constants/post_constants.jsx');

var PostActions = {
  listPosts: function(data) {
    AppDispatcher.handleAction({
      actionType: PostConstants.POST_LIST,
      data: data
    });
  },
  showPost: function(id) {
    AppDispatcher.handleAction({
      actionType: PostConstants.POST_SHOW,
      id: id
    });
  },
  createPost: function(data) {
    AppDispatcher.handleAction({
      actionType: PostConstants.POST_CREATE,
      data: data
    });
  },
  newPost: function(data) {
    AppDispatcher.handleAction({
      actionType: PostConstants.POST_NEW,
      data: data
    });
  },
  updatePost: function(data) {
    AppDispatcher.handleAction({
      actionType: PostConstants.POST_UPDATE,
      data: data
    });
  },
  editPost: function(data) {
    AppDispatcher.handleAction({
      actionType: PostConstants.POST_EDIT,
      data: data
    });
  },
  destroyPost: function(id) {
    AppDispatcher.handleAction({
      actionType: PostConstants.POST_DESTROY,
      id: id
    });
  }
};

module.exports = PostActions;

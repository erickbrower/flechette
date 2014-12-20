var Backbone = require('backbone');

var Router = Backbone.Router.extend({
  routes: {
    '/^posts\/(\d+)/': 'postById',
    '/^posts\/[a-z0-9-]+/': 'postBySlug',
    'posts/create': 'postCreate', 
    '*actions': 'index'
  }
});

module.exports = Router;

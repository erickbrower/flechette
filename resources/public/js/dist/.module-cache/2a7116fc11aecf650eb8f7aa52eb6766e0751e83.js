var React = require('react');

var PostExcerptView = React.createClass({displayName: 'PostExcerptView',
  render: function() {
    var post = this.props.post;
    return (
      React.createElement("div", {className: "blog-post"}, 
        React.createElement("h2", {className: "blog-post-title"}, 
          React.createElement("a", {href: "/posts/{post.slug}", rel: "bookmark"}, post.title)
        ), 
        React.createElement("p", {className: "blog-post-meta"}, post.created_at, " by ", React.createElement("a", {href: "/pages/about"}, "Erick")), 
        React.createElement("p", {dangerouslySetInnerHTML: {__html: this._getPostBody()}})
      )
    );
  },
  _getPostBody: function() {
    var body = this.props.post.body;
    if (body) {
      body = body.substring(0, 500);
    }
    return body;
  }
});

module.exports = PostExcerptView;

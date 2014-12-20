var React = require('react'),
  _ = require('underscore'),
  PostExcerptView = require('./post_excerpt_view.jsx');

var PostExcerptListView = React.createClass({displayName: 'PostExcerptListView',
  render: function() {
    var rows = _.map(this.props.posts, function(post) {
      return (React.createElement(PostExcerptView, {post: post}));
    });
    return (
      React.createElement("div", {className: "col-sm-8"}, rows)
    );
  }
});

module.exports = PostExcerptListView;

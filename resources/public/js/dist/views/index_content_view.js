var React = require('react'),
  PostExcerptListView = require('./post_excerpt_list_view.jsx'),
  SidebarView = require('./sidebar_view.jsx');

var IndexContentView = React.createClass({displayName: 'IndexContentView',
  render: function() {
    return (
      React.createElement("div", null, 
        React.createElement(PostExcerptListView, {posts: this.props.posts}), 
        React.createElement(SidebarView, null)
      )
    );
  }
});

module.exports = IndexContentView;

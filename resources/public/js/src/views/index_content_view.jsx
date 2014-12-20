var React = require('react'),
  PostExcerptListView = require('./post_excerpt_list_view.jsx'),
  SidebarView = require('./sidebar_view.jsx');

var IndexContentView = React.createClass({
  render: function() {
    return (
      <div>
        <PostExcerptListView posts={this.props.posts} />
        <SidebarView />
      </div>
    );
  }
});

module.exports = IndexContentView;

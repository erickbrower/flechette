var React = require('react'),
  _ = require('underscore'),
  PostExcerptView = require('./post_excerpt_view.jsx');

var PostExcerptListView = React.createClass({
  render: function() {
    var rows = _.map(this.props.posts, function(post) {
      return (<PostExcerptView post={post} />);
    });
    return (
      <div className="col-sm-8">{rows}</div>
    );
  }
});

module.exports = PostExcerptListView;

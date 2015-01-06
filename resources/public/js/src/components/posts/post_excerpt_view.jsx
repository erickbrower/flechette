var React = require('react');

var PostExcerptView = React.createClass({
  render: function() {
    var post = this.props.post;
    return (
      <div className="blog-post">
        <h2 className="blog-post-title">
          <a href="/posts/{post.slug}" rel="bookmark">{post.title}</a>
        </h2>
        <p className="blog-post-meta">{post.created_at} by <a href="/pages/about">Erick</a></p>
        <p dangerouslySetInnerHTML={{__html: this._getPostBody()}} />
      </div>
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

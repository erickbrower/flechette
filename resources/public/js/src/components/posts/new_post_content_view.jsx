var React = require('react'),
  NewPostFormView = require('./new_post_form_view.jsx');

var NewPostContentView = React.createClass({
  render: function() {
    return (
      <div className="col-sm-12">
        <NewPostFormView />
      </div>
    );
  }
});

module.exports = NewPostContentView;

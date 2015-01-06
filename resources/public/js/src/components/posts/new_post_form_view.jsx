var React = require('react');

var NewPostFormView = React.createClass({
  render: function() {
    return (
      <form className="form-horizontal" role="form">
        <div className="form-group">
          <div className="col-sm-12">
            <input type="text" className="form-control" id="post-title" placeholder="Title" />
          </div> 
        </div>
        <div className="form-group">
          <div className="col-sm-12">
            <input type="text" className="form-control" id="post-body" placeholder="Post stuff!" />
          </div> 
        </div>
        <div className="form-group">
          <div className="col-sm-12">
            <button type="button" className="btn btn-primary">Post</button>
          </div>
        </div>
      </form>
    );
  }
});

module.exports = NewPostFormView;

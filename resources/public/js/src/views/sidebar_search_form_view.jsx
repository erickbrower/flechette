var React = require('react');

var SidebarSearchFormView = React.createClass({
  render: function() {
    return (
      <div className="input-group">
        <input type="text" className="form-control" id="search-input" placeholder="Search" />
        <span className="input-group-btn">
          <button type="button" className="btn btn-sm btn-primary" id="search-btn">Go</button>
        </span>
      </div>
    );
  }
});

module.exports = SidebarSearchFormView;

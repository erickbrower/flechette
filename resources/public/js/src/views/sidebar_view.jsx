var React = require('react'),
  SidebarSearchFormView = require('./sidebar_search_form_view.jsx');

var SidebarView = React.createClass({
  render: function() {
    return (
      <div className="col-sm-3 col-sm-offset-1 blog-sidebar">
        <div className="sidebar-module sidebar-module-inset">
          <SidebarSearchFormView />
        </div>
        <div className="sidebar-module">
          <h4>Elsewhere</h4>
          <ol className="list-unstyled">
            <li><a href="http://github.com/erickbrower">GitHub</a></li>
            <li><a href="http://twitter.com/erickbrower">Twitter</a></li>
          </ol>
        </div>
      </div>
    );
  }
});

module.exports = SidebarView;

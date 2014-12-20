var React = require('react'),
  SidebarSearchFormView = require('./sidebar_search_form_view.jsx');

var SidebarView = React.createClass({displayName: 'SidebarView',
  render: function() {
    return (
      React.createElement("div", {className: "col-sm-3 col-sm-offset-1 blog-sidebar"}, 
        React.createElement("div", {className: "sidebar-module sidebar-module-inset"}, 
          React.createElement(SidebarSearchFormView, null)
        ), 
        React.createElement("div", {className: "sidebar-module"}, 
          React.createElement("h4", null, "Elsewhere"), 
          React.createElement("ol", {className: "list-unstyled"}, 
            React.createElement("li", null, React.createElement("a", {href: "http://github.com/erickbrower"}, "GitHub")), 
            React.createElement("li", null, React.createElement("a", {href: "http://twitter.com/erickbrower"}, "Twitter"))
          )
        )
      )
    );
  }
});

module.exports = SidebarView;

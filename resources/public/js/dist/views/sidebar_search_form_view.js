var React = require('react');

var SidebarSearchFormView = React.createClass({displayName: 'SidebarSearchFormView',
  render: function() {
    return (
      React.createElement("div", {className: "input-group"}, 
        React.createElement("input", {type: "text", className: "form-control", id: "search-input", placeholder: "Search"}), 
        React.createElement("span", {className: "input-group-btn"}, 
          React.createElement("button", {type: "button", className: "btn btn-sm btn-primary", id: "search-btn"}, "Go")
        )
      )
    );
  }
});

module.exports = SidebarSearchFormView;

import React, { Component } from "react";
import PropTypes from "prop-types";

class Member extends Component {
  render() {
    const { member } = this.props;
    return (
    <div>
      <select className="selectpicker" multiple data-actions-box="true">
  <option value={member}>{member.fullName}</option>
</select>
</div>
    );
  }
}

export default Member;

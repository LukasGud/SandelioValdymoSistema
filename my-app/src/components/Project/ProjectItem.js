import React, { Component } from "react";
import { Link } from "react-router-dom";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { deleteProject } from "../../actions/projectActions";

class ProjectItem extends Component {
  onDeleteClick = firstName => {
    this.props.deleteProject(firstName);
  };
  render() {
    const { project } = this.props;
    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-2">
              <span className="mx-auto">{project.firstName}</span>
            </div>
            <div className="col-lg-6 col-md-4 col-8">
              <h3>{project.firstName}</h3>
              <p>{project.nameOfStock}</p>
            </div>
            <div className="col-md-4 d-none d-lg-block">
              <ul className="list-group">
                <a href="#">
                  <li className="list-group-item board">
                    <i className="fa fa-flag-checkered pr-1"> Storage Board </i>
                  </li>
                </a>
                <Link to={`/updateProject/${project.firstName}`}>
                  <li className="list-group-item update">
                    <i className="fa fa-edit pr-1"> Update Storage Info</i>
                  </li>
                </Link>

                <li
                  className="list-group-item delete"
                  onClick={this.onDeleteClick.bind(
                    this,
                    project.firstName
                  )}
                >
                  <i className="fa fa-minus-circle pr-1"> Delete Storage</i>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

ProjectItem.propTypes = {
  deleteProject: PropTypes.func.isRequired
};

export default connect(
  null,
  { deleteProject }
)(ProjectItem);

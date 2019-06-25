import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createProject } from "../../actions/projectActions";
import classnames from "classnames";

class AddProject extends Component {
  constructor() {
    super();

    this.state = {
      firstName: "",
      lastName: "",
      birthYear: "",
      phoneNumber: "",
      type: "",
      nameOfStock: "",
      weight: "",
      placeOfStorage: "",
      created_At: "",
      errors: {}
    };

    this.OnChange = this.OnChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
  }

  OnChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();
    const newProject = {
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      birthYear: this.state.birthYear,
      phoneNumber: this.state.phoneNumber,
      type: this.state.type,
      nameOfStock: this.state.nameOfStock,
      weight: this.state.weight,
      placeOfStorage: this.state.placeOfStorage,
      created_At: this.state.created_At
    };
    this.props.createProject(newProject, this.props.history);
  }
  render() {
    const { errors } = this.state;
    return (
      <div>
        <div className="project">
          <div className="container">
            <div className="row">
              <div className="col-md-8 m-auto">
                <h5 className="display-4 text-center">Create Project form</h5>
                <hr />
                <form onSubmit={this.onSubmit}>
                  <div className="form-group">
                    <input
                      type="text"
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.firstName
                      })}
                      placeholder="First Name"
                      name="firstName"
                      value={this.state.firstName}
                      onChange={this.OnChange}
                    />
                    {errors.firstName && (
                      <div className="invalid-feedback">
                        {errors.firstName}
                      </div>
                    )}
                  </div>

                  <div className="form-group">
                    <input
                      type="text"
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.lastName
                      })}
                      placeholder="Last Name"
                      name="lastName"
                      value={this.state.lastName}
                      onChange={this.OnChange}
                    />
                    {errors.lastName && (
                      <div className="invalid-feedback">
                        {errors.lastName}
                      </div>
                    )}
                  </div>

                  <div className="form-group">
                    <textarea
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.birthYear
                      })}
                      placeholder="Year of birth"
                      name="birthYear"
                      value={this.state.birthYear}
                      onChange={this.OnChange}
                    />
                    {errors.yearOfBirth && (
                      <div className="invalid-feedback">
                        {errors.birthYear}
                      </div>
                    )}
                  </div>

                  <div className="form-group">
                    <textarea
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.phoneNumber
                      })}
                      placeholder="Phone number"
                      name="phoneNumber"
                      value={this.state.phoneNumber}
                      onChange={this.OnChange}
                    />
                    {errors.phoneNumber && (
                      <div className="invalid-feedback">
                        {errors.phoneNumber}
                      </div>
                    )}
                  </div>

                  <div className="form-group">
                    <textarea
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.type
                      })}
                      placeholder="Client Type"
                      name="type"
                      value={this.state.type}
                      onChange={this.OnChange}
                    />
                    {errors.type && (
                      <div className="invalid-feedback">
                        {errors.type}
                      </div>
                    )}
                  </div>
                  <div className="form-group">
                    <textarea
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.nameOfStock
                      })}
                      placeholder="Name of stock"
                      name="nameOfStock"
                      value={this.state.nameOfStock}
                      onChange={this.OnChange}
                    />
                    {errors.nameOfStock && (
                      <div className="invalid-feedback">
                        {errors.nameOfStock}
                      </div>
                    )}
                  </div>
                  <div className="form-group">
                    <textarea
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.weight
                      })}
                      placeholder="Weight"
                      name="weight"
                      value={this.state.weight}
                      onChange={this.OnChange}
                    />
                    {errors.weight && (
                      <div className="invalid-feedback">
                        {errors.weight}
                      </div>
                    )}
                  </div>
                  <div className="form-group">
                    <textarea
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.placeOfStorage
                      })}
                      placeholder="Place of storage"
                      name="placeOfStorage"
                      value={this.state.placeOfStorage}
                      onChange={this.OnChange}
                    />
                    {errors.placeOfStorage && (
                      <div className="invalid-feedback">
                        {errors.placeOfStorage}
                      </div>
                    )}
                  </div>

                  <h6>Start Date</h6>
                  <div className="form-group">
                    <input
                      type="date"
                      className="form-control form-control-lg"
                      name="created_At"
                      value={this.state.created_At}
                      onChange={this.OnChange}
                    />
                  </div>
                  
                  <input
                    type="submit"
                    className="btn btn-primary btn-block mt-4"
                  />
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

AddProject.propTypes = {
  createProject: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  errors: state.errors
});

export default connect(
  mapStateToProps,
  { createProject }
)(AddProject);

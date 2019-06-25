import React, { Component } from "react";
import { getProject, createProject } from "../../actions/projectActions";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import classnames from "classnames";

class UpdateProject extends Component {
  constructor() {
    super();

    this.state = {
      id: "",
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
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
    const {
      id,
      firstName,
      lastName,
      birthYear,
      phoneNumber,
      type,
      nameOfStock,
      weight,
      placeOfStorage,
      created_At,
    } = nextProps.project;

    this.setState({
      id,
      firstName,
      lastName,
      birthYear,
      phoneNumber,
      type,
      nameOfStock,
      weight,
      placeOfStorage,
      created_At,
    });
  }

  componentDidMount() {
    const { id } = this.props.match.params;
    this.props.getProject(id, this.props.history);
  }

  onChange(e) {
    this.setState({
      [e.target.name]: e.target.value
    });
  }

  onSubmit(e) {
    e.preventDefault();

    const updateProject = {
      id: this.state.id,
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

    this.props.createProject(updateProject, this.props.history);
  }
  render() {
    const { errors } = this.state;
    return (
      <div className="project">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">Update Storage form</h5>
              <hr />
              <form onSubmit={this.onSubmit}>
                <div className="form-group">
                  <input
                    type="text"
                    className={classnames("form-control form-control-lg", {
                      "is-invalid": errors.firstName
                    })}
                    placeholder="Project Name"
                    name="firstName"
                    value={this.state.firstName}
                    onChange={this.onChange}
                  />
                  {errors.firstName && (
                    <div className="invalid-feedback">{errors.firstName}</div>
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
                    onChange={this.onChange}
                    disabled
                  />
                </div>

                <div className="form-group">
                  <textarea
                    className={classnames("form-control form-control-lg", {
                      "is-invalid": errors.birthYear
                    })}
                    placeholder="Birth year"
                    name="birthYear"
                    value={this.state.birthYear}
                    onChange={this.onChange}
                  />
                  {errors.firstName && (
                    <div className="invalid-feedback">{errors.birthYear}</div>
                  )}
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
    );
  }
}

UpdateProject.propTypes = {
  getProject: PropTypes.func.isRequired,
  createProject: PropTypes.func.isRequired,
  project: PropTypes.object.isRequired,
  errors: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  project: state.project.project,
  errors: state.errors
});

export default connect(
  mapStateToProps,
  { getProject, createProject }
)(UpdateProject);

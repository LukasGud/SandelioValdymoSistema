import axios from "axios";
import { GET_ERRORS, GET_PROJECTS, GET_PROJECT, DELETE_PROJECT } from "./types";
import { async } from "q";

export const createProject = (project, history) => async dispatch => {
  try {
    const res = await axios.post("/api/user", project);
    history.push("/dashboard");
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: {}
    });
  }
};

export const getProjects = () => async dispatch => {
  const res = await axios.get("/api/user/all");
  dispatch({
    type: GET_PROJECTS,
    payload: res.data
  });
};

export const getProject = (firstName, history) => async dispatch => {
  try {
    const res = await axios.get(`/api/user/${firstName}`);
    dispatch({
      type: GET_PROJECT,
      payload: res.data
    });
  } catch (error) {
    history.push("/dashboard");
  }
};

export const deleteProject = firstName => async dispatch => {
  if (
    window.confirm(
      "Are you sure? This will delete the project and all the data related to it"
    )
  ) {
    await axios.delete(`/api/project/${firstName}`);
    dispatch({
      type: DELETE_PROJECT,
      payload: firstName
    });
  }
};

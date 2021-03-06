import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import projectReducer from "./projectReducers";
import backlogReducer from "./backlogReducer";
import securityReducer from "./securityReducers";

export default combineReducers({
  errors: errorReducer,
  project: projectReducer,
  backlog: backlogReducer,
  security: securityReducer
});
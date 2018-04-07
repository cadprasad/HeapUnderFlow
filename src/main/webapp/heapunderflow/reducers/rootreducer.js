import { combineReducers } from 'redux'
import {userReducer} from './userReducer'
import {blogReducer} from './blogReducer'

export default combineReducers({
  user : userReducer,
  blogs : blogReducer
})
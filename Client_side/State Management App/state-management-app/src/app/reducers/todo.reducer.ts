import { ActionParent } from "../actions/todo.action";
import { Todo } from "../models/Todo";

const initialState: Todo[]=[
    {title:"Create Entity"},
    {title:"Create Reducer"},
    {title:"Initialize enitity(model) in reducer"}
]

export function TodoReducer(state = initialState, action :ActionParent){
    switch(action.type){
        default: return state;
    }
}
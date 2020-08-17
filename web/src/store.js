export const MUTATION_KEYS = Object.freeze({
  SET_LISTS: "SET_LISTS",
});

const state = {
  lists: [],
};

const actions = {};

// mutations
const mutations = {
  [MUTATION_KEYS.SET_LISTS]: (state, data) => {
    state.lists = JSON.parse(JSON.stringify(data));
  },
};

const getters = {};

export default {
  state,
  mutations,
  actions,
  getters,
};

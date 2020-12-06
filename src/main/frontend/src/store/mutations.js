export default {
  SET_USER_INFO (state, user) {
    state.user = user
  },

  SET_CATEGORIES (state, categories) {
    state.categories.data = categories
  },

  SET_CATEGORY (state, category) {
    const index = state.categories.data.findIndex(c => c.id === category.id)
    if (index !== -1) {
      state.categories.data[index] = category
    } else {
      state.categories.data.push(category)
    }
  },

  DELETE_CATEGORY (state, id) {
    const index = state.categories.data.findIndex(c => c.id === id)
    if (index !== -1) {
      state.categories.data.splice(index, 1)
    }
  },

  SET_QUESTIONNAIRES (state, questionnaires) {
    state.questionnaires.data = questionnaires
  },

  SET_QUESTIONNAIRE (state, questionnaire) {
    const index = state.questionnaires.data.findIndex(q => q.id === questionnaire.id)
    if (index !== -1) {
      state.questionnaires.data[index] = questionnaire
    } else {
      state.questionnaires.data.push(questionnaire)
    }
  },

  DELETE_QUESTIONNAIRE (state, id) {
    const index = state.questionnaires.data.findIndex(q => q.id === id)
    if (index !== -1) {
      state.questionnaires.data.splice(index, 1)
    }
  }
}

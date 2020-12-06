export default {
  activeQuestionnaires: state => {
    return state.questionnaires.data.filter(q => q.activation !== null)
  },

  wipQuestionnaires: state => {
    return state.questionnaires.data.filter(q => q.activation === null)
  }
}

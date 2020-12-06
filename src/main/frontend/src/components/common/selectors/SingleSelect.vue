<template>
  <v-select
    :value="value"
    :items="options"
    menu-props="auto"
    :label="label"
    hide-details
    :prepend-icon="icon"
    single-line
    :name="name"
    :error="error"
    :autocomplete="false"
    @input="$emit('input', $event)"
  />
</template>

<script>
export default {
  name: 'SingleSelect',

  props: {
    /**
     * label of the text input
     */
    label: {
      type: String,
      default: 'Label'
    },
    /**
     * icon displayed before the text input
     * (if empty no icon is displayed)
     */
    icon: {
      type: String,
      default: ''
    },
    /**
     * mark the text input as invalid
     */
    error: {
      type: Boolean,
      default: false
    },
    /**
     * value of the text input
     */
    value: {
      type: String
    },
    /**
     * name of the text input field
     * (works like name field on html input tag)
     */
    name: {
      type: String,
      default: null
    },
    /**
     * selectable options
     */
    options: {
      type: Array,
      default: () => { return [] }
    }
  }
}
</script>

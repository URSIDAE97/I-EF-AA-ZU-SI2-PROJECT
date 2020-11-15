<template>
  <v-text-field
    :value="value"
    :label="label"
    :error="error"
    :counter="maxlength"
    :type="show_content ? 'text' : 'password'"
    :name="name"
    :prepend-icon="icon"
    :append-icon="show_content ? 'mdi-eye' : 'mdi-eye-off'"
    @click:append="show_content = !show_content"
    @input="$emit('input', $event)"
    @keypress.enter="$emit('enter')"
  />
</template>

<script>
export default {
  name: 'PasswordInput',

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
      type: String,
      required: true
    },
    /**
     * maximal length of the text input
     * (if null no limit is applied)
     */
    maxlength: {
      type: Number,
      default: null
    },
    /**
     * name of the text input field
     * (works like name field on html input tag)
     */
    name: {
      type: String,
      default: null
    }
  },

  data () {
    return {
      show_content: false
    }
  }
}
</script>

<template>
  <div>
    <v-alert
      v-model='alert'
      dismissible
      type='success'
      icon='done'
    >This is a success alert that is closable.</v-alert>

    <div class='text-xs-center'>
      <v-btn v-if='!alert' color='primary' dark @click='alert = true'>Reset</v-btn>
    </div>
    <v-alert
      :value='true'
      color='success'
      icon='new_releases'
    >This is a success alert with a custom icon.</v-alert>

    <v-alert :value='true' color='error'>This is an error alert with no icon.</v-alert>
    <div class='text-xs-center'>
      <v-btn color='primary' @click='alert = !alert'>Toggle</v-btn>
    </div>
    <v-alert :value='alert' type='success' transition='slide-y-transition'>This is a success alert.</v-alert>
    <v-alert :value='true' color='success' outline>This is a success alert.</v-alert>

    <v-alert :value='true' color='info' icon='info' outline>This is an info alert.</v-alert>

    <v-alert :value='true' color='warning' icon='priority_high' outline>This is a warning alert.</v-alert>

    <v-alert :value='true' color='error' icon='warning' outline>This is a error alert.</v-alert>
  </div>
</template>
<script>
export default {
  data() {
    return {
      alert: true
    }
  }
}
</script>

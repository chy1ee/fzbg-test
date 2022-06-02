<template>
  <div>
    <img alt="Vue logo" src="@/assets/logo.png">
    <div>{{ data }}</div>
  </div>
</template>

<script>
import { reactive, toRefs } from 'vue'
import axios from "axios"

export default {
  name: 'App2',
  setup() {
    const state = reactive({
      data: ''
    })

    axios.get("/yy").then(res => {
      state.data = res.data
    })

    return {
      ...toRefs(state)
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

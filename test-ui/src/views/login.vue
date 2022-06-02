<template>
  <div>正在跳转：{{ code }}</div>
</template>

<script>
import axios from "axios"
import { useRouter } from 'vue-router'
import { defineComponent, reactive, toRefs } from 'vue'

export default defineComponent({
  setup() {
    const state = reactive({
      code: ''
    })

    const router = useRouter()
    axios.get("/code").then(res => {
      console.log(res)
      state.code = res.data.data

      if (state.code) {
        setTimeout(() => {
          axios.get("/code?code="+state.code).then(() => {
            router.push("/home")
          })
        }, 3000)
      }
    })

    return {
      ...toRefs(state)
    }
  },
})
</script>


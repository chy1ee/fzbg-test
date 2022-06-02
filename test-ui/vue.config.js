const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  publicPath: "/ui",
  devServer: {
    proxy: {
      '/dev-api': {
        target: 'http://localhost:9000',
        pathRewrite:{
            '^/dev-api': '/'
        }
      }
    }
  }
})

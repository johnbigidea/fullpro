const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  publicPath:'./',
  outputDir:'../dist',
  assetsDir:'./',
  devServer:{
    proxy:{
      '/api':{
        target:'http://localhost:9090/',
        changeOrigin:true,
        pathRewrite:{
          '^/api':''
        }
      }
    }
  }
})

module.exports = {
  'lintOnSave': false,
  'transpileDependencies': [
    'vuetify'
  ],
  runtimeCompiler: true,
  devServer: {
    port: 8081,
    disableHostCheck: true,
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        ws: true,
      }
    }
  }
}

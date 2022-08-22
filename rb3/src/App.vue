<template>

<div id="app">
  <el-radio-group   v-model="isCollapse" @change="ggh" style="margin-bottom: 20px">
    <el-radio-button label="me">我的</el-radio-button>
    <el-radio-button  label="jj">概念</el-radio-button>
        <el-radio-button disabled label="sf">公式</el-radio-button>
    <el-radio-button disabled label="kj">真题</el-radio-button>
        <el-radio-button disabled label="zl">难点</el-radio-button>
    <el-radio-button disabled label="sj">关系</el-radio-button>
        <el-radio-button disabled label="cg">复杂</el-radio-button>
    <el-radio-button disabled label="hy">逻辑</el-radio-button>
    <el-radio-button disabled label="lx">联想</el-radio-button>
    <el-radio-button disabled label="ll">举例</el-radio-button>
    <el-radio-button label="lr">录入</el-radio-button>
  </el-radio-group>
  <div style="display:flex;flex-content:center" >

  <router-view></router-view>
  </div>




</div>
</template>
<style scoped>
#t{
  width: 8%;

}

.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
</style>

<script>
import axios from 'axios'
import vueaxios from 'vue-axios'
import {getallw,createw} from './api.js'
import { ElButton,ElRow,ElTabs,ElTabPane,ElCol,ElMenu,ElMenuItem,ElMenuItemGroup,ElSubMenu,ElRadioGroup,ElRadioButton,ElInput,ElIcon} from 'element-plus'




export default {
  data(){
    return{
      isCollapse:"",

    }
  },
  methods:{
    ggh(e){

  // console.log(this.isCollapse)
  if(this.isCollapse=="lr"){
    // alert('df')
    
     this.$router.push('/inputcontent')
  }else if(this.isCollapse=="me"){
        this.$router.push('/home')

      }else if(this.isCollapse=="jj"){
        this.$router.push('/about')

      }else if(this.isCollapse=="sf"){
        this.$router.push('/about2')

      }else if(this.isCollapse=="kj"){
        this.$router.push('/about3')

      }else if(this.isCollapse=="zl"){
        this.$router.push('/about4')

      }else if(this.isCollapse=="sj"){
        this.$router.push('/about5')

      }else if(this.isCollapse=="cg"){
        this.$router.push('/about6')

      }
    },
    handleOpen(e){
      const that = this
      if(e==0){
        getallw().then((res)=>{
          console.log(res)
        })

      }else if(e==1){

      }else if(e==2){
        
      }else if(e==3){
        
      }else if(e==4){
        
      }else if(e==5){
        
      }else if(e==6){
        
      }else if(e==7){
        
      }else if(e==8){
        
      }else if(e==9){
        
      }else if(e==10){
        
      }
  
    },
    getapi(){

    },
    renderview(){

    },

    
    tabchange(w){
      alert(w)
      if(w==1){
        this.$router.push('/about')
      }else if(w==2){
        this.$router.push('/about2')
      }else if(w==3){
         this.$router.push('/about3')
      }else if(w==4){
         this.$router.push('/about4')
      }else if(w==5){
         this.$router.push('/about5')
      }else if(w==6){
         this.$router.push('/about6')
      }else if(w==0){
          this.$router.push('/home')      
      }
    }

  },
  name: 'App',
          components:{
            ElButton,
            ElRow,ElTabs,ElTabPane,ElCol,ElMenu,ElMenuItem,ElMenuItemGroup,ElSubMenu,ElRadioGroup,ElRadioButton,ElInput,ElIcon
        }

}
</script>


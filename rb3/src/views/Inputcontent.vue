<template>

<div style="display:flex;justify-content:space-around;flex-direction:column;margin-left:30px;width:80%"  > 
    <!-- <el-button type="primary">Primary</el-button> -->
    <!-- <el-button type="success">Success</el-button> -->

    <div v-if="a0" style="display:flex">经济<el-input v-model="input11" @focus='chan1'  style="width:10%" placeholder="Please input" /><el-input v-model="input1" @change='changeee0'    placeholder="概念" /></div>
    <br/>
    <div v-if="a1" style="display:flex">税法<el-input v-model="input21" @focus='chan2'  style="width:10%" placeholder="Please input" /><el-input v-model="input2" @change='changeee1'    placeholder="公式" /></div>
    <br/>
    <div  v-if="a2" style="display:flex">会计<el-input v-model="input31" @focus='chan3'  style="width:10%" placeholder="Please input" /><el-input v-model="input3" @change='changeee2'    placeholder="真题" /></div>
    <br/>
    <div  v-if="a3" style="display:flex">战略<el-input v-model="input41" @focus='chan4'  style="width:10%" placeholder="Please input" /><el-input v-model="input4" @change='changeee3'    placeholder="思维误区" /></div>
    <br/>
    <div  v-if="a4" style="display:flex">审计<el-input v-model="input51" @focus='chan5'  style="width:10%" placeholder="Please input" /><el-input v-model="input5" @change='changeee4'    placeholder="简单关系" /></div>
    <br/>
    <div  v-if="a5" style="display:flex">财管<el-input v-model="input61" @focus='chan6'  style="width:10%" placeholder="Please input" /><el-input v-model="input6" @change='changeee5'    placeholder="复杂关系" /></div>
    <br/>
    <!-- <div v-if="a6" style="display:flex">逻辑<el-input v-model="input71" @focus='chan7'  style="width:10%" placeholder="Please input" /><el-input v-model="input7" @change='changeee6'    placeholder="逻辑" /></div>
    <br/>
    <div v-if="a7" style="display:flex">联想<el-input v-model="input81" @focus='chan8'  style="width:10%" placeholder="Please input" /><el-input v-model="input8" @change='changeee7'    placeholder="联想" /></div>
    <br/>
    <div v-if="a8" style="display:flex">栗子<el-input v-model="input91" @focus='chan9'  style="width:10%" placeholder="Please input" /><el-input v-model="input9" @change='changeee8'    placeholder="例子" /></div>
    <br/> -->
    <!-- <el-button label="确定"  >确定</el-button>  -->

      <el-radio-group v-model="radio">
    <el-radio :label="1">概念</el-radio>
    <el-radio disabled :label="2">税法</el-radio>
    <el-radio disabled :label="3">会计</el-radio>
        <el-radio disabled :label="4">战略</el-radio>
    <el-radio disabled :label="5">审计</el-radio>
    <el-radio disabled :label="6">财管</el-radio>
  </el-radio-group>
    

</div>
</template>





<script>
import {getallw,createw,createeq,createcom,createsim,createwr,createex,createlo,createque,createim} from '../api.js'
import { ElButton,ElRow,ElTabs,ElTabPane,ElCol,ElMenu,ElMenuItem,ElMenuItemGroup,ElSubMenu,ElRadioGroup,ElRadioButton,ElInput,ElSelect,ElOption,ElRadio,ElMessage} from 'element-plus'

    // 录入关系 概念之间的关系，简单关系
     //录入真题-真题是什么，我的思路，思路为什么错了，答案的思路是什么，从几个角度，信息，关键问题，目的，观点，结果，假定，概念，推断
     //录入思维误区。可以从上面自动复制一部分过来，认知日志
    // 录入复杂 长度长，长逻辑，多米诺关系
    // 录入逻辑 事情，行业信念，我的假定，行业假定，我的推断
    // 录入联想，原话，比喻
    // 录入例子，好玩的例子，
    // 行业黑话，语境，认知公平，世界观，行业关，无关与我，我的过去，我的理解
    // watch耳机电话随时提醒，艾宾浩斯记忆曲线

export default {
  data(){
    return{
        radio:'0',
        a0:true,
        a1:true,
        a2:true,
        a3:true,
        a4:true,
        a5:true,
        a6:true,
        a7:true,
        a8:true,
        
      input1:"",
      input2:"",
      input3:"",
      input4:"",
      input5:"",
      input6:"",
      input7:"",
      input8:"",
      input9:"",
      
      input11:"",
      input21:"",
      input31:"",
      input41:"",
      input51:"",
      input61:"",
      input71:"",
      input81:"",
      input91:"",

      
      options: [
  {
    value: '1',
    label: '白',
  },
  {
    value: '黑',
    label: '黑',
  },
]
    }
  },
  methods:{
    reshow(){
      const that = this
            that.a0=true
      that.a1=true
      that.a2=true
      that.a3=true
      that.a4=true
      that.a5=true
      that.a6=true
      that.a7=true
      that.a8=true
    },
    chan1(){
      this.a1=false
      this.a2=false
      this.a3=false
      this.a4=false
      this.a5=false
      this.a6=false
      this.a7=false
      this.a8=false
    },
        chan2(){
      this.a0=false
      this.a2=false
      this.a3=false
      this.a4=false
      this.a5=false
      this.a6=false
      this.a7=false
      this.a8=false
    },
        chan3(){
      this.a1=false
      this.a0=false
      this.a3=false
      this.a4=false
      this.a5=false
      this.a6=false
      this.a7=false
      this.a8=false
    },
        chan4(){
      this.a1=false
      this.a2=false
      this.a0=false
      this.a4=false
      this.a5=false
      this.a6=false
      this.a7=false
      this.a8=false
    },
        chan5(){
      this.a1=false
      this.a2=false
      this.a3=false
      this.a0=false
      this.a5=false
      this.a6=false
      this.a7=false
      this.a8=false
    },
        chan6(){
      this.a1=false
      this.a2=false
      this.a3=false
      this.a4=false
      this.a0=false
      this.a6=false
      this.a7=false
      this.a8=false
    },
        chan7(){
      this.a1=false
      this.a2=false
      this.a3=false
      this.a4=false
      this.a5=false
      this.a0=false
      this.a7=false
      this.a8=false
    },
        chan8(){
      this.a1=false
      this.a2=false
      this.a3=false
      this.a4=false
      this.a5=false
      this.a6=false
      this.a0=false
      this.a8=false
    },
        chan9(){
      this.a1=false
      this.a2=false
      this.a3=false
      this.a4=false
      this.a5=false
      this.a6=false
      this.a7=false
      this.a0=false
    },
    changeee0(a){
        var w = "gn"
        const that = this
let date  = new Date()
        let x = date.valueOf()  // 当前时间戳

        let dd = {}
        dd.id=""
        dd.times=7
        dd.f1=""
        dd.f2=""
        dd.f3=""
        dd.f4=""
        dd.f5=""
        dd.f6=""
        dd.f7=""
        dd.f8=""
        dd.edittime=x
        dd.addtime=x
        dd.name=that.input11
        dd.define = that.input1.replace(/\s*/g,'')
        
        if(that.radio!=0&&that.input11.length!=0&&that.input1.length!=0){
                 if(that.radio==1){
          dd.f9 = '经济法'
        }else if(that.radio==2){
          dd.f9 = '税法'
        }else if(that.radio==3){
          dd.f9 = '会计'
        }else if(that.radio==4){
          dd.f9 = '战略'
        }else if(that.radio==5){
          dd.f9 = '审计'
        }else if(that.radio==6){
          dd.f9 = '财管'
        }

        createw(dd).then((res)=>{

          if(res.status=="201"){
              ElMessage({
    message: '添加'+dd.f9+'概念成功',
    grouping: true,
    type: 'success',
  })
  
  this.reshow()
          }
        })  
        }else{
          alert("空科目")
        }
 


    },
    changeee1(a){
        var w = "gs"

         const that = this
        let date  = new Date()
                let x = date.valueOf()  // 当前时间戳

        let dd = {}
        dd.id=""
        dd.times=7
        dd.f1=""
        dd.f2=""
        dd.f3=""
        dd.f4=""
        dd.f5=""
        dd.f6=""
        dd.f7=""
        dd.f8=""
        dd.edittime=x
        dd.addtime=x
        dd.name=that.input21
        
        dd.define = that.input2.replace(/\s*/g,'')

        

        if(that.radio!=0&&that.input21.length!=0&&that.input2.length!=0){
                 if(that.radio==1){
          dd.f9 = '经济法'
        }else if(that.radio==2){
          dd.f9 = '税法'
        }else if(that.radio==3){
          dd.f9 = '会计'
        }else if(that.radio==4){
          dd.f9 = '战略'
        }else if(that.radio==5){
          dd.f9 = '审计'
        }else if(that.radio==6){
          dd.f9 = '财管'
        }

        createeq(dd).then((res)=>{
          

          if(res.status=="201"){
              ElMessage({
    message: '添加'+dd.f9+'公式成功',
    grouping: true,
    type: 'success',
  })
  
  this.reshow()
          }
        })  
        }else{
          alert("空科目")
        }
 
        
    },
    changeee2(a){
        var w = "zt"
                 const that = this
        let date  = new Date()
                let x = date.valueOf()  // 当前时间戳
        
        let dd = {}
        dd.id=""
        dd.times=7
        dd.f1=""
        dd.f2=""
        dd.f3=""
        dd.f4=""
        dd.f5=""
        dd.f6=""
        dd.f7=""
        dd.f8=""
        dd.edittime=x
        dd.addtime=x
        dd.name=that.input31
        dd.define = that.input3.replace(/\s*/g,'')
        if(that.radio!=0&&that.input31.length!=0&&that.input3.length!=0){
                 if(that.radio==1){
          dd.f9 = '经济法'
        }else if(that.radio==2){
          dd.f9 = '税法'
        }else if(that.radio==3){
          dd.f9 = '会计'
        }else if(that.radio==4){
          dd.f9 = '战略'
        }else if(that.radio==5){
          dd.f9 = '审计'
        }else if(that.radio==6){
          dd.f9 = '财管'
        }

        createque(dd).then((res)=>{

          if(res.status=="201"){
              ElMessage({
    message: '添加'+dd.f9+'真题成功',
    grouping: true,
    type: 'success',
  })
  
  this.reshow()
          }
        })  
        }else{
          alert("空科目")
        }
    },
    changeee3(a){
        var w = "nd"
        const that = this
        let date  = new Date()
                let x = date.valueOf()  // 当前时间戳
        
        let dd = {}
        dd.id=""
        dd.times=7
        dd.f1=""
        dd.f2=""
        dd.f3=""
        dd.f4=""
        dd.f5=""
        dd.f6=""
        dd.f7=""
        dd.f8=""
        dd.edittime=x
        dd.addtime=x
        dd.name=that.input41
        dd.define = that.input4.replace(/\s*/g,'')
        if(that.radio!=0&&that.input41.length!=0&&that.input4.length!=0){
                 if(that.radio==1){
          dd.f9 = '经济法'
        }else if(that.radio==2){
          dd.f9 = '税法'
        }else if(that.radio==3){
          dd.f9 = '会计'
        }else if(that.radio==4){
          dd.f9 = '战略'
        }else if(that.radio==5){
          dd.f9 = '审计'
        }else if(that.radio==6){
          dd.f9 = '财管'
        }

        createwr(dd).then((res)=>{
    
          if(res.status=="201"){
              ElMessage({
    message: '添加'+dd.f9+'思维误区成功',
    grouping: true,
    type: 'success',
  })
  
  this.reshow()
          }
        })  
        }else{
          alert("空科目")
        }
    },
    changeee4(a){
        var w = "gx"
        const that = this
        let date  = new Date()
                let x = date.valueOf()  // 当前时间戳
        
        let dd = {}
        dd.id=""
        dd.times=7
        dd.f1=""
        dd.f2=""
        dd.f3=""
        dd.f4=""
        dd.f5=""
        dd.f6=""
        dd.f7=""
        dd.f8=""
        dd.edittime=x
        dd.addtime=x
        dd.name=that.input51
        dd.define = that.input5.replace(/\s*/g,'')
        if(that.radio!=0&&that.input51.length!=0&&that.input5.length!=0){
                 if(that.radio==1){
          dd.f9 = '经济法'
        }else if(that.radio==2){
          dd.f9 = '税法'
        }else if(that.radio==3){
          dd.f9 = '会计'
        }else if(that.radio==4){
          dd.f9 = '战略'
        }else if(that.radio==5){
          dd.f9 = '审计'
        }else if(that.radio==6){
          dd.f9 = '财管'
        }

        createsim(dd).then((res)=>{
   
          if(res.status=="201"){
              ElMessage({
    message: '添加'+dd.f9+'简单关系成功',
    grouping: true,
    type: 'success',
  })
  
  this.reshow()
          }
        })  
        }else{
          alert("空科目")
        }
    },
    changeee5(a){
        var w = "fz"
        const that = this
        let date  = new Date()
                let x = date.valueOf()  // 当前时间戳
        
        let dd = {}
        dd.id=""
        dd.times=7
        dd.f1=""
        dd.f2=""
        dd.f3=""
        dd.f4=""
        dd.f5=""
        dd.f6=""
        dd.f7=""
        dd.f8=""
        dd.edittime=x
        dd.addtime=x
        dd.name=that.input61
        dd.define = that.input6.replace(/\s*/g,'')
        if(that.radio!=0&&that.input61.length!=0&&that.input6.length!=0){
                 if(that.radio==1){
          dd.f9 = '经济法'
        }else if(that.radio==2){
          dd.f9 = '税法'
        }else if(that.radio==3){
          dd.f9 = '会计'
        }else if(that.radio==4){
          dd.f9 = '战略'
        }else if(that.radio==5){
          dd.f9 = '审计'
        }else if(that.radio==6){
          dd.f9 = '财管'
        }

        createcom(dd).then((res)=>{
    
          if(res.status=="201"){
              ElMessage({
    message: '添加'+dd.f9+'复杂关系成功',
    grouping: true,
    type: 'success',
  })
  
  this.reshow()
          }
        })  
        }else{
          alert("空科目")
        }
    },
    changeee6(a){
         var w = "lj"
        const that = this
        let date  = new Date()
                let x = date.valueOf()  // 当前时间戳
        
        let dd = {}
        dd.id=""
        dd.times=7
        dd.f1=""
        dd.f2=""
        dd.f3=""
        dd.f4=""
        dd.f5=""
        dd.f6=""
        dd.f7=""
        dd.f8=""
        dd.edittime=x
        dd.addtime=x
        dd.name=that.input71
        dd.define = that.input7.replace(/\s*/g,'')
        if(that.radio!=0&&that.input71.length!=0&&that.input7.length!=0){
                 if(that.radio==1){
          dd.f9 = '经济法'
        }else if(that.radio==2){
          dd.f9 = '税法'
        }else if(that.radio==3){
          dd.f9 = '会计'
        }else if(that.radio==4){
          dd.f9 = '战略'
        }else if(that.radio==5){
          dd.f9 = '审计'
        }else if(that.radio==6){
          dd.f9 = '财管'
        }

        createlo(dd).then((res)=>{
  
          if(res.status=="201"){
              ElMessage({
    message: '添加'+dd.f9+'逻辑成功',
    grouping: true,
    type: 'success',
  })
  
  this.reshow()
          }
        })  
        }else{
          alert("空科目")
        }
    },
    changeee7(a){
         var w = "lx"
        const that = this
        let date  = new Date()
                let x = date.valueOf()  // 当前时间戳
        
        let dd = {}
        dd.id=""
        dd.times=7
        dd.f1=""
        dd.f2=""
        dd.f3=""
        dd.f4=""
        dd.f5=""
        dd.f6=""
        dd.f7=""
        dd.f8=""
        dd.edittime=x
        dd.addtime=x
        dd.name=that.input81
        dd.define = that.input8.replace(/\s*/g,'')
        if(that.radio!=0&&that.input81.length!=0&&that.input8.length!=0){
                 if(that.radio==1){
          dd.f9 = '经济法'
        }else if(that.radio==2){
          dd.f9 = '税法'
        }else if(that.radio==3){
          dd.f9 = '会计'
        }else if(that.radio==4){
          dd.f9 = '战略'
        }else if(that.radio==5){
          dd.f9 = '审计'
        }else if(that.radio==6){
          dd.f9 = '财管'
        }

        createim(dd).then((res)=>{
      
          if(res.status=="201"){
              ElMessage({
    message: '添加'+dd.f9+'联想成功',
    grouping: true,
    type: 'success',
  })
  
  this.reshow()
          }
        })  
        }else{
          alert("空科目")
        }
    },
     changeee8(a){
        var w = "lz"
        const that = this
        let date  = new Date()
                let x = date.valueOf()  // 当前时间戳
        
        let dd = {}
        dd.id=""
        dd.times=7
        dd.f1=""
        dd.f2=""
        dd.f3=""
        dd.f4=""
        dd.f5=""
        dd.f6=""
        dd.f7=""
        dd.f8=""
        dd.edittime=x
        dd.addtime=x
        dd.name=that.input91
        dd.define = that.input9.replace(/\s*/g,'')
        if(that.radio!=0&&that.input91.length!=0&&that.input9.length!=0){
                 if(that.radio==1){
          dd.f9 = '经济法'
        }else if(that.radio==2){
          dd.f9 = '税法'
        }else if(that.radio==3){
          dd.f9 = '会计'
        }else if(that.radio==4){
          dd.f9 = '战略'
        }else if(that.radio==5){
          dd.f9 = '审计'
        }else if(that.radio==6){
          dd.f9 = '财管'
        }

        createex(dd).then((res)=>{

          if(res.status=="201"){
              ElMessage({
    message: '添加'+dd.f9+'实例成功',
    grouping: true,
    type: 'success',
  })
  
  this.reshow()
          }
        })  
        }else{
          alert("空科目")
        }
    },
    
    
  },
  name: '',
          components:{
            ElButton,
            ElRow,ElTabs,ElTabPane,ElCol,ElMenu,ElMenuItem,ElMenuItemGroup,ElSubMenu,ElRadioGroup,ElRadioButton,ElInput,ElSelect,ElOption,ElRadio,ElMessage

        }

}
</script>





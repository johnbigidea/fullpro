<template>


    经济法---{{wer}}
    <div style="display:flex;">
      <el-menu
    default-active="0"
id="t"


   @select="handleOpen"

  >
       <el-menu-item  index="0">
      <el-icon></el-icon>
      <template #title>概念</template>
    </el-menu-item>
        <el-menu-item  index="1">
      <el-icon></el-icon>
      <template #title>公式</template>
    </el-menu-item>
        <el-menu-item  index="2">
      <el-icon></el-icon>
      <template #title>真题</template>
    </el-menu-item>
        <el-menu-item  index="3">
      <el-icon></el-icon>
      <template #title>难点</template>
    </el-menu-item>
        <el-menu-item  index="4">
      <el-icon></el-icon>
      <template #title>关系</template>
    </el-menu-item>
        <el-menu-item  index="5">
      <el-icon></el-icon>
      <template #title>互动记忆</template>
    </el-menu-item>
        <el-menu-item  index="6">
      <el-icon></el-icon>
      <template #title>七次记忆</template>
    </el-menu-item>
            <el-menu-item  index="7">
      <el-icon></el-icon>
      <template #title>复杂</template>
    </el-menu-item>
            <el-menu-item  index="8">
      <el-icon></el-icon>
      <template #title>逻辑</template>
    </el-menu-item>
            <el-menu-item  index="9">
      <el-icon></el-icon>
      <template #title>联想</template>
    </el-menu-item>
                <el-menu-item  index="10">
      <el-icon></el-icon>
      <template #title>举例</template>
    </el-menu-item>

  </el-menu>

  <el-table :data="tableData"  
  
    :default-sort = "{prop: 'edittime', order: 'ascending'}">
    <el-table-column  align="center" fixed prop="name" label="name" width="80" />
    <el-table-column  align="center" prop="id" label="id" width="50" />
    
    <el-table-column  align="center" prop="times" label="times" width="70" />
    <!-- <el-table-column  align="center" :show-overflow-tooltip="true" prop="addtime" sortable label="addtime" width="200" /> -->
    <el-table-column  align="center" prop="edittime" :show-overflow-tooltip="true" sortable label="edittime" width="200" />
    <el-table-column  :show-overflow-tooltip="true"  align="center" prop="define" label="define"  width="600"/>
    <el-table-column  align="center" fixed="right" label="Operations" width="160">
        
      <template #default="scope">
        <el-button link type="primary" size="small" @click="wclick(scope.$index, scope.row)"
          >Igot</el-button
        >
        <el-button link type="primary" size="small"></el-button>
         <el-button link type="primary" size="small" @click="dclick(scope.$index, scope.row)">dontget</el-button>
      </template>
    </el-table-column>
  </el-table>
    
</div>
</template>

<script>
import { ElButton,ElRow,ElTabs,ElTabPane,ElCol,ElMenu,ElMenuItem,ElMenuItemGroup,ElSubMenu,ElRadioGroup,ElRadioButton,ElInput,ElIcon,ElTable,ElTableColumn} from 'element-plus'
import {getallw,getalleq,getallcom,getallsim,getalllo,getallque,getallim,getallex,getallwr, insertim} from '../api.js'
import {dw,deq,dcom,dsim,dlo,dque,dim,dwr,dex} from '../api.js'
import {insertw,inserteq,insertcom,insertsim,insertlo,insertque,insertwr,insertex} from '../api.js'


export default({
    
    created(){
      const that = this
          getallw().then((res)=>{
          console.log(res.data.Employee_List[0][0].addtime)
          that.tableData = res.data.Employee_List[0];
          let showtable = []
          for(var i=0;i<that.tableData.length;i++){
            if(that.tableData[i].f9=="战略"){
              showtable.push(that.tableData[i])
            }
          }
 
          that.tableData=showtable


        })
     
 

    },
    data(){
        return{
            wer:"概念",
            tableData:[],
            
            
        }
    },
    setup() {
        
    },
        methods:{
           getLocalTime(nS) {     
		var d = new Date(parseInt(nS)* 1000);    //根据时间戳生成的时间对象
		var date = (d.getFullYear()) + "-" + 
					(d.getMonth() + 1) + "-" +
					(d.getDate()) + " " + 
					(d.getHours()) + ":" + 
					(d.getMinutes()) + ":" + 
					(d.getSeconds()); 
		return date;   
},
            handleClick(){

            },
            dclick(a,b){   
              if(that.wer=="概念"){
              dw(b.id).then((res)=>{
               this.$router.go(0)
              })

              }else if(that.wer=="公式"){
                              deq(b.id).then((res)=>{
               this.$router.go(0)    
              })

              }else if(that.wer=="真题"){
                              dque(b.id).then((res)=>{
               this.$router.go(0)    
              })

              }else if(that.wer=="难点"){
                              dwr(b.id).then((res)=>{
               this.$router.go(0)    
              })

              }else if(that.wer=="关系"){
                              dsim(b.id).then((res)=>{
               this.$router.go(0)    
              })

              }else if(that.wer=="复杂"){
                              dcom(b.id).then((res)=>{
               this.$router.go(0)    
              })

              }else if(that.wer=="逻辑"){
                              dlo(b.id).then((res)=>{
               this.$router.go(0)    
              })

              }else if(that.wer=="联想"){
                              dim(b.id).then((res)=>{
               this.$router.go(0)    
              })

              }else if(that.wer=="实例"){
                              dex(b.id).then((res)=>{
               this.$router.go(0)    
              })

              }

            },
            wclick(a,b){
                const that = this
        
        let dd = {}
        dd.id=b.id
        switch (b.times) 
{ 
  case 7:dd.times=6;
  var date1  = new Date()
        
  var d0 = date1.setMinutes(date1.getMinutes()+20)
                var x0 = d0.valueOf()  // 当前时间戳
                dd.edittime=x0;
  break; 
  case 6:dd.times=5; 
    var date2  = new Date()
   var d1 = date2.setHours(date2.getHours()+1)
                var x1 = d1.valueOf()  // 当前时间戳
                dd.edittime=x1;
  break; 
  case 5:dd.times=4; 
    var date3  = new Date()
   var d2 = date3.setHours(date3.getHours()+8)
                var x2 = d2.valueOf()  // 当前时间戳
                dd.edittime=x2;
            
  break; 
  case 4:dd.times=3; 
    var date4  = new Date()
   var d3 = date4.setHours(date4.getHours()+24)
                var x3= d3.valueOf()  // 当前时间戳
                dd.edittime=x3;
           
  break; 
  case 3:dd.times=2; 
    var date5  = new Date()
   
   var d4 = date5.setHours(date5.getHours()+48)
                var x4 = d4.valueOf()  // 当前时间戳
                dd.edittime=x4;
  break; 
  case 2:dd.times=1; 
    var date6  = new Date()
   var d5 = date6.setHours(date6.getHours()+144)
  
                var x5 = d5.valueOf()  // 当前时间戳
                dd.edittime=x5;
  break; 
  case 1:dd.times=0; 

  break; 
}
     
        dd.f1=""
        dd.f2=""
        dd.f3=""
        dd.f4=""
        dd.f5=""
        dd.f6=""
        dd.f7=""
        dd.f8=""
    
        
        dd.addtime=b.addtime
        dd.name=b.name
        dd.define = b.define
        dd.f9 = b.f9
        if(dd.times!=0){
          console.log(dd)


          if(that.wer=="概念"){
              insertw(dd).then((res)=>{
            console.log(res)
            that.handleOpen(0)
 

          })

              }else if(that.wer=="公式"){
           
                              inserteq(dd).then((res)=>{
            console.log(res)
            that.handleOpen(1)

 

          })

              }else if(that.wer=="真题"){
                              insertque(dd).then((res)=>{
            console.log(res)
            that.handleOpen(2)
 

          })

              }else if(that.wer=="难点"){
                              insertwr(dd).then((res)=>{
            console.log(res)
            that.handleOpen(3)
 

          })

              }else if(that.wer=="关系"){
                              insertsim(dd).then((res)=>{
            console.log(res)
            that.handleOpen(4)
 

          })

              }else if(that.wer=="复杂"){
                             insertcom(dd).then((res)=>{
            console.log(res)
            this.$router.go(5)
 

          })

              }else if(that.wer=="逻辑"){
                              insertlo(dd).then((res)=>{
            console.log(res)
            that.handleOpen(6)
 

          })
              }else if(that.wer=="联想"){
                             insertim(dd).then((res)=>{
            console.log(res)
            that.handleOpen(7)
 

          })

              }else if(that.wer=="实例"){
                             insertex(dd).then((res)=>{
            console.log(res)
            that.handleOpen(8)
 

          })

              }

        }
      
        
            },

            handleOpen(e){
            
      const that = this
      if(e==0){
                    const that = this
        that.wer = "概念"
        getallw().then((res)=>{
          console.log(res)
                    console.log(res.data.Employee_List[0][0].addtime)
          that.tableData = res.data.Employee_List[0];
          let showtable = []
          for(var i=0;i<that.tableData.length;i++){
            if(that.tableData[i].f9=="战略"){
              showtable.push(that.tableData[i])
            }
          }
 
          that.tableData=showtable
        })

      }else if(e==1){
        const that = this
        that.wer = "公式"
                getalleq().then((res)=>{
                    console.log(res.data.Employee_List[0][0].addtime)
          that.tableData = res.data.Employee_List[0];
          let showtable = []
          for(var i=0;i<that.tableData.length;i++){
            if(that.tableData[i].f9=="战略"){
              showtable.push(that.tableData[i])
            }
          }
 
          that.tableData=showtable
        })

      }else if(e==2){
                const that = this
        that.wer = "真题"
         getallque().then((res)=>{
                    console.log(res.data.Employee_List[0][0].addtime)
          that.tableData = res.data.Employee_List[0];
          let showtable = []
          for(var i=0;i<that.tableData.length;i++){
            if(that.tableData[i].f9=="战略"){
              showtable.push(that.tableData[i])
            }
          }
 
          that.tableData=showtable
        })
        
      }else if(e==3){
                const that = this
        that.wer = "难点"
                 getallwr().then((res)=>{
                    console.log(res.data.Employee_List[0][0].addtime)
          that.tableData = res.data.Employee_List[0];
          let showtable = []
          for(var i=0;i<that.tableData.length;i++){
            if(that.tableData[i].f9=="战略"){
              showtable.push(that.tableData[i])
            }
          }
 
          that.tableData=showtable
        })
        
        
      }else if(e==4){
                const that = this
        that.wer = "关系"
                         getallsim().then((res)=>{
                    console.log(res.data.Employee_List[0][0].addtime)
          that.tableData = res.data.Employee_List[0];
          let showtable = []
          for(var i=0;i<that.tableData.length;i++){
            if(that.tableData[i].f9=="战略"){
              showtable.push(that.tableData[i])
            }
          }
 
          that.tableData=showtable
        })
        
      }else if(e==5){
                const that = this
        that.wer = "。。"
        
      }else if(e==6){
                const that = this
        that.wer = "。。"
        
      }else if(e==7){
                const that = this
        that.wer = "复杂"
                           getallcom().then((res)=>{
          console.log(res)
        })
        
      }else if(e==8){
                const that = this
        that.wer = "逻辑"
         getalllo().then((res)=>{
                    console.log(res.data.Employee_List[0][0].addtime)
          that.tableData = res.data.Employee_List[0];
          let showtable = []
          for(var i=0;i<that.tableData.length;i++){
            if(that.tableData[i].f9=="战略"){
              showtable.push(that.tableData[i])
            }
          }
 
          that.tableData=showtable
        })
        
      }else if(e==9){
                const that = this
        that.wer = "联想"
          getallim().then((res)=>{
                    console.log(res.data.Employee_List[0][0].addtime)
          that.tableData = res.data.Employee_List[0];
          let showtable = []
          for(var i=0;i<that.tableData.length;i++){
            if(that.tableData[i].f9=="战略"){
              showtable.push(that.tableData[i])
            }
          }
 
          that.tableData=showtable
        })
        
      }else if(e==10){
                const that = this
        that.wer = "实例"
            getallex().then((res)=>{
                    console.log(res.data.Employee_List[0][0].addtime)
          that.tableData = res.data.Employee_List[0];
          let showtable = []
          for(var i=0;i<that.tableData.length;i++){
            if(that.tableData[i].f9=="战略"){
              showtable.push(that.tableData[i])
            }
          }
 
          that.tableData=showtable
        })
        
      }
  
    },
        
    },
      name: 'App',
          components:{
            ElButton,
            ElRow,ElTabs,ElTabPane,ElCol,ElMenu,ElMenuItem,ElMenuItemGroup,ElSubMenu,ElRadioGroup,ElRadioButton,ElInput,ElIcon,ElTable,ElTableColumn
        }
})
</script>




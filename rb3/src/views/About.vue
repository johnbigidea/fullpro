<template>

    <div style="display:flex;width:100%">
      <div style="width:10%">
        
        
      <el-menu 
    default-active="0"
id="t"
   @select="handleOpen"
  >
  <div>
    概念
     <el-progress :percentage="Math.ceil(tfinish*100/(ttotal*7))"  style="margin-top:10px;margin-left:50px"/> 
      <div style="display:flex;flex-direction:column;align-item:center;justify-content:space-around"><div>还需{{thours}}小时 </div><el-input v-model="dfsa" @change="submits" ></el-input></div>

  
</div>
       <el-menu-item  index="0">
        
      <el-icon></el-icon>
      <template #title>经济法</template>
    </el-menu-item>
        <el-menu-item  index="1">
      <el-icon></el-icon>
      <template #title>税法</template>
    </el-menu-item>
        <el-menu-item  index="2">
      <el-icon></el-icon>
      <template #title>会计</template>
    </el-menu-item>
        <el-menu-item  index="3">
      <el-icon></el-icon>
      <template #title>战略</template>
    </el-menu-item>
        <el-menu-item  index="4">
      <el-icon></el-icon>
      <template #title>审计</template>
    </el-menu-item>
        <el-menu-item  index="5">
      <el-icon></el-icon>
      <template #title>财管</template>
    </el-menu-item>
        <!-- <el-menu-item  index="6">
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
    </el-menu-item> -->

  </el-menu>
      </div>

<div style="display:flex;flex-direction:column;width:100%">
  <el-table :data="tableData"  @row-click='wclick'
  
    >
    <el-table-column :show-overflow-tooltip="true" align="center" fixed prop="name" label="name" width="150" />
    <!-- <el-table-column  align="center" prop="id" label="id" width="70" /> -->
    
        <el-table-column prop="times" label="progress" width="100" >
      <template #default="scope">
       <el-progress :percentage="Math.floor((7-scope.row.times)*100/7)" />
      </template>
       </el-table-column>
    <!-- <el-table-column  align="center" :show-overflow-tooltip="true" prop="addtime" sortable label="addtime" width="200" /> -->
    <!-- <el-table-column  align="center" prop="edittime" :show-overflow-tooltip="true"  label="time" width="60" /> -->
    <el-table-column  :show-overflow-tooltip="false"  align="center" prop="define" label="define"  min-width="400"/>
    <el-table-column  align="center" fixed="right" label="Operations" width="110">
        
      <template #default="scope">
        
        <!-- <el-button v-if="scope.row.times!=0" link type="primary" size="small" @click="wclick(scope.$index, scope.row)"
          >Igot</el-button> -->
          <div style="display:flex;">
        <el-button  type="primary" color="#626aef"      @click.stop="openview(scope.$index, scope.row)" >view</el-button>
         <!-- <el-button type="primary" color="#626aef"    @click.stop="edit(scope.$index, scope.row)">Edit</el-button> -->
         <!-- <el-button type="primary" color="#626aef"    @click.stop="mark(scope.$index, scope.row)">Mark</el-button> -->
           </div>
      </template>
      
    </el-table-column>
    



  </el-table>
   

    <div style="z-index:100000;opacity:0.7;width:90%"><el-pagination style="float:right" @current-change="pagechange" @prev-click="lastpage" @next-click="nextpage" hide-on-single-page prev-text="上一页" next-text="下一页" layout="prev, pager, next" :page-size="5" :total="ttotal" /> </div>
</div>



<!-- 人生有限弹框1 -->
  <div v-show="showtip" style="width:80%;position:fixed;border: 3px dotted;z-index:1000000;margin-left:10%;height:80%;margin-top:2%;background-color:white;">
    <el-container style="height:100%;text-align:center">
      <el-header style="background-color:#c6e2ff">
        <div style="width:100%">{{titlet}} ({{ttlength}}/{{tt.length}}) <span style="float:right"><el-button @click="cclose">close</el-button></span></div>

      </el-header>
  
      <el-main style="background-color:#ecf5ff">
      <el-table :data="tt" style="width: 95%;margin:0 auto">
        <!-- <el-table-column prop="index" label="no" width="50" /> -->
        <el-table-column prop="id" label="id" width="70" />
        <el-table-column prop="define"  :show-overflow-tooltip="true"  label="define" />
         
          

 
    <!-- <el-table-column prop="define" label="define"  /> -->
    <el-table-column prop="f9" label="f9"  width="100"/>
    <el-table-column prop="times" label="progress" width="180" >
      <template #default="scope">
           <el-progress :percentage="Math.floor((7-scope.row.times)*100/7)" />
      </template>
       </el-table-column>

           <el-table-column  align="center" fixed="right" label="Operations" width="160">
        
      <template #default="scope">

         <el-button link type="primary" size="small" @click="dclick2(scope.$index, scope.row)">dontget</el-button>
      </template>
    </el-table-column>
    <!-- <el-table-column prop="address" label="Address" /> -->
  </el-table>
  </el-main>
  


  <el-footer style="background-color:#c6e2ff">
      人生有限公司|2022-2032 张荣燊
  </el-footer>
    </el-container>
</div>



<!-- 人生有限弹框2 -->
  <div v-show="showtip2" style="width:80%;position:fixed;border: 3px dotted;z-index:1000000;margin-left:10%;height:80%;margin-top:2%;background-color:white;">
    <el-container style="height:100%;text-align:center">
      <el-header style="background-color:#c6e2ff">
        <div style="width:100%">{{titlet}} ({{ttlength}}/{{tt.length}}) <span style="float:right"><el-button @click="cclose">close</el-button></span></div>

      </el-header>
  
      <el-main style="background-color:#ecf5ff">
      <el-table :data="tt" style="width: 95%;margin:0 auto">
        <!-- <el-table-column prop="index" label="no" width="50" /> -->
        <el-table-column prop="id" label="id" width="70" />
        <el-table-column prop="define"  :show-overflow-tooltip="true"  label="define" />
         
          

 
    <!-- <el-table-column prop="define" label="define"  /> -->
    <el-table-column prop="f9" label="f9"  width="100"/>
    <el-table-column prop="times" label="progress" width="180" >
      <template #default="scope">
           <el-progress :percentage="Math.floor((7-scope.row.times)*100/7)" />
      </template>
       </el-table-column>

           <el-table-column  align="center" fixed="right" label="Operations" width="160">
        
      <template #default="scope">

         <el-button link type="primary" size="small" @click="dclick2(scope.$index, scope.row)">dontget</el-button>
      </template>
    </el-table-column>
    <!-- <el-table-column prop="address" label="Address" /> -->
  </el-table>
  </el-main>
  


  <el-footer style="background-color:#c6e2ff">
      人生有限公司|2022-2032 张荣燊
  </el-footer>
    </el-container>
</div>




<!-- <div id="shade"></div> -->



    
</div>

</template>

<script>
import { ElButton,ElRow,ElTabs,ElTabPane,ElCol,ElMenu,ElMenuItem,ElMenuItemGroup,ElSubMenu,ElRadioGroup,ElRadioButton,ElInput,ElIcon,ElTable,ElTableColumn,ElPopover,ElHeader,ElMain,ElAside,ElFooter,ElContainer,ElProgress,ElPagination} from 'element-plus'
import {getallw, insertim} from '../api.js'
import {dw,deq,dcom,dsim,dlo,dque,dim,dwr,dex} from '../api.js'
import {insertw,inserteq,insertcom,insertsim,insertlo,insertque,insertwr,insertex,getallbyname,getallcontainname} from '../api.js'


export default({
    
    created(){
      const that = this
      var datad = {
        pagesize:0,
        pageN:5,
        cat:'经济法',
        whichrelation:'word',
        doneornot:'notdone'
      }

      var datadone = {
        pagesize:0,
        pageN:5,
        cat:'经济法',
        whichrelation:'word',
        doneornot:'done'
      }

          getallw(datad).then((res)=>{
          console.log(res.data.Employee_List[0][0].addtime)
          that.tableData = res.data.Employee_List[0];
          let showtable = []
          for(var i=0;i<that.tableData.length;i++){
            if(that.tableData[i].f9=="经济法"){
              showtable.push(that.tableData[i])
            }
          }
          that.tableData=showtable
          that.ttotal = res.data.total
        })

        getallw(datadone).then((res)=>{

          
          if(res.data.status==false){
            that.tfinish = 0
            
            console.log( that.tfinish, that.ttotal)
          }else{
            that.tfinish = res.data.finish
              console.log( that.tfinish, that.ttotal)
          }
         
  
        })
     
 

    },
    data(){
        return{
            wer:0,
            thiscount:0,
            onechange:0,
            avchange:0,
            avtotal:0,
            lasttime:0,
            tableData:[],
            tt:[
     
            ],
            dfsa:'搜索',
            timetotal:0,
            thours:0,
            showtip:false,
            showtip2:false,
            titlet:'',
            searchrow:'',
            ttotal:0,
            ttlength:0,
            tfinish:0,
        }
    },
    setup() {
        
    },
        methods:{
          mark(a,b){
            alert(b)

          },
          submits(){
            const that =this
            // alert(that.dfsa)
            let data = {
              name:that.dfsa,
              tt:"word"
            }

getallcontainname(data).then(res=>{
  console.log(res)

  that.tableData = res.data.tt

}

)

          },
          edit(){

          },
          pagechange(e){
            // console.log(e)
                  const that = this
      var datad = {
        pagesize:e-1,
        pageN:5,
        cat:'经济法',
        whichrelation:'word',
        doneornot:'notdone'
      }

             getallw(datad).then((res)=>{
          console.log(res.data.Employee_List[0][0].addtime)
          that.tableData = res.data.Employee_List[0];
          let showtable = []
          for(var i=0;i<that.tableData.length;i++){
            if(that.tableData[i].f9=="经济法"){
              showtable.push(that.tableData[i])
            }
          }
          that.tableData=showtable
          that.ttotal = res.data.total
        })
            
          },
                   
          cclose(){
            const that = this
            that.showtip=false

          },
          openview(a,b){
            const that = this
            that.tt = []
            that.searchrow=b

            that.showtip = true
            console.log(b.name)
            that.titlet = b.name
            let data = {
              name:that.titlet
            }
            getallbyname(data).then(res=>{
              // console.log(res)
              let gdata  =res.data
             
                var item = gdata['Employee'];

if(item.length!=0){
  that.ttlength=0
  for(var i=0;i<item.length;i++){
  
    that.tt.push(item[i])
    if(item[i].times==0){
      that.ttlength+=1
    }
  }

}









 

            })
            


          },
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
            // cc(a){
            //   console.log(a.times)
            //   alert('df')
            // },
            dclick(a,b){   
              const that = this
              if(that.wer=="概念"){
              dw(b.id).then((res)=>{
               that.handleOpen(0)
              })

              }else if(that.wer=="公式"){
                              deq(b.id).then((res)=>{
              that.handleOpen(1)   
              })

              }else if(that.wer=="真题"){
                              dque(b.id).then((res)=>{
               that.handleOpen(2)   
              })

              }else if(that.wer=="难点"){
                              dwr(b.id).then((res)=>{
               that.handleOpen(3)   
              })

              }else if(that.wer=="关系"){
                              dsim(b.id).then((res)=>{
               that.handleOpen(4)   
              })

              }else if(that.wer=="复杂"){
                              dcom(b.id).then((res)=>{
               that.handleOpen(5)   
              })

              }else if(that.wer=="逻辑"){
                              dlo(b.id).then((res)=>{
               that.handleOpen(6)   
              })

              }else if(that.wer=="联想"){
                              dim(b.id).then((res)=>{
               that.handleOpen(7)    
              })

              }else if(that.wer=="实例"){
                              dex(b.id).then((res)=>{
               that.handleOpen(8)  
              })

              }

            },

                        dclick2(a,b){   
              const that = this
             
              dw(b.id).then((res)=>{
                that.handleOpen(that.wer)   
               that.openview('',that.searchrow)
              })

             

            },


            wclick(b){

                const that = this
                that.thiscount+=1
                if(that.lasttime==0){
                  that.onechange =0
                  that.lasttime = new Date()
                }else{
                  let thistime =  new Date()

                  that.onechange  = (thistime-that.lasttime)/1000
                  that.lasttime = thistime

                }
                that.avtotal+=that.onechange
                console.log(that.avtotal,that.thiscount)
                that.avchange = (that.avtotal/(that.thiscount-1)).toFixed(2)
                that.timetotal = (that.avchange * that.ttotal).toFixed(1)
                that.thours = ((that.ttotal*7-that.tfinish)*that.avchange/3600).toFixed(2)
                console.log(that.ttotal,that.tfinish,that.avchange,'sdfd')



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
  dd.edittime="9999999999999";

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
        if(dd.times>=0){
          console.log(dd)
         insertw(dd).then((res)=>{
            console.log(res)
            that.handleOpen(that.wer)
 

          })

        }
      
        
            },

            handleOpen(e){

            
      const that = this
      let datad
      let datadone
      if(e==0){
                  
        // that.wer = "概念"
               datad = {
        pagesize:0,
        pageN:5,
        cat:'经济法',
        whichrelation:'word',
        doneornot:'notdone'

      }

      datadone = {
        pagesize:0,
        pageN:5,
        cat:'经济法',
        whichrelation:'word',
        doneornot:'done'

      }


      }else if(e==1){
      
        // that.wer = "公式"
           datad = {
        pagesize:0,
        pageN:5,
        cat:'税法',
         whichrelation:'word',
        doneornot:'notdone'
      }

      datadone = {
        pagesize:0,
        pageN:5,
        cat:'税法',
         whichrelation:'word',
        doneornot:'done'
      }
            

      }else if(e==2){
        // that.wer = "真题"
           datad = {
        pagesize:0,
        pageN:5,
        cat:'会计',
        whichrelation:'word',
        doneornot:'notdone'
      
      }

      datadone = {
        pagesize:0,
        pageN:5,
        cat:'会计',
        whichrelation:'word',
        doneornot:'done'
      
      }

        
      }else if(e==3){
               
        // that.wer = "难点"
         datad = {
        pagesize:0,
        pageN:5,
        cat:'战略',
        whichrelation:'word',
        doneornot:'notdone'
        
        
      }

      datadone = {
        pagesize:0,
        pageN:5,
        cat:'战略',
        whichrelation:'word',
        doneornot:'done'
        
        
      }

        
        
      }else if(e==4){
          
        // that.wer = "关系"
         datad = {
        pagesize:0,
        pageN:5,
        cat:'审计',
        whichrelation:'word',
        doneornot:'notdone'
      }

       datadone = {
        pagesize:0,
        pageN:5,
        cat:'审计',
        whichrelation:'word',
        doneornot:'done'
      }

        
      }else if(e==5){
                 datad = {
        pagesize:0,
        pageN:5,
        cat:'财管',
        whichrelation:'word',
        doneornot:'notdone'
      }
               datadone = {
        pagesize:0,
        pageN:5,
        cat:'财管',
        whichrelation:'word',
        doneornot:'done'
      }
      }

          getallw(datad).then((res)=>{
                    console.log(res.data.Employee_List[0][0].addtime)
          that.tableData = res.data.Employee_List[0];
          that.ttotal = res.data.total
         
   
  
        })

                  getallw(datadone).then((res)=>{

          
          if(res.data.status==false){
            that.tfinish = 0
            
            console.log( that.tfinish, that.ttotal)
          }else{
            that.tfinish = res.data.finish
              console.log( that.tfinish, that.ttotal)
          }
         
  
        })

        that.wer = e
        
  
    },
        
    },
      name: 'App',
          components:{
            ElButton,
            ElRow,ElTabs,ElTabPane,ElCol,ElMenu,ElMenuItem,ElMenuItemGroup,ElSubMenu,ElRadioGroup,ElRadioButton,ElInput,ElIcon,ElTable,ElTableColumn,ElPopover,ElHeader,ElMain,ElAside,ElFooter,ElContainer,ElProgress,ElPagination
        }
})
</script>

<style scoped>
 #shade{
        position:absolute;
        top:0;
        left:0;
        z-index:2;
        /*z-index 属性设置元素的堆叠顺序。拥有更高堆叠顺序的元素总是会处于堆叠顺序较低的元素的前面。*/
        width:100%;
        height:100%;
        background-color:#000;
        opacity:0.3;
        /*opacity透明度*/
        /*兼容IE8及以下版本浏览器*/
        filter: alpha(opacity=30);
        display:none;
        
    }

    .example-pagination-block + .example-pagination-block {
  margin-top: 10px;
}
.example-pagination-block .example-demonstration {
  margin-bottom: 16px;
}

</style>




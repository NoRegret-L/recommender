<template>

    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column
          type="index"
          :index=1 label="index" width="300">
      </el-table-column>
      <el-table-column
          prop="uid"
          label="uid"
          width="300">
      </el-table-column>
      <el-table-column
          prop="mid"
          label="mid"
          width="300">
      </el-table-column>
      <el-table-column
          prop="hs"
          label="hs"
          width="300">
      </el-table-column>
    </el-table>
</template>

<script>
import request from "@/utils/request";

export default {
  data() {
    return {
      tableData: []
    }
  },
  created() {
    this.load();
  },
  methods:{
    load(){
      request.get("/preference").then(res=>{
        if (res.code === '0'){
          this.tableData=res.data;
        }else {

        }
      })
    }
  }
}
</script>
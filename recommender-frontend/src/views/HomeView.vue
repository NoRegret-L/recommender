<template>
  <div>
    <div>
      <el-row justify="center" type="flex">
        <el-col :span="3" style="text-align:right">用户 ID：</el-col>
        <el-col :span="3">
          <el-input v-model="params.uid" placeholder="请输入内容"></el-input>
        </el-col>
      </el-row>
      <el-row justify="center" type="flex">
        <el-col :span="3" style="text-align:right">推荐数目：</el-col>
        <el-col :span="3">
          <el-input v-model="params.size" placeholder="25"></el-input>
        </el-col>
      </el-row>
    </div>
    <div>
      <el-radio-group v-model="params.type">
        <el-radio :label="0">基于内容</el-radio>
        <el-radio :label="1">基于行为</el-radio>
        <el-radio :label="2">混合推荐</el-radio>
      </el-radio-group>
    </div>
    <div id="bt">
      <el-button type="primary" @click="run()">提交</el-button>
    </div>
    <div>
      <h3>推荐结果：</h3>
      <el-table
          class="center"
          :data="tableData"
          style="width: 900px">
        <el-table-column
            label="mid"
            prop="mid"
            width="250">
        </el-table-column>
        <el-table-column
            label="片名"
            prop="name"
            width="250">
        </el-table-column>
        <el-table-column
            label="链接"
            prop="link"
            width="400">
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<style>
.center {
  margin: auto;
}
#bt{
  margin-top: 20px;
}

</style>

<script>

import request from "@/utils/request";

export default {
  name: 'HomeView',
  data() {
    return {
      params: {
        uid: '2774',
        size: '5',
        type: '-1',
      },
      tableData: []
    }
  },
  created() {
  },
  methods: {
    run() {
      request.get("/recommend", {
        params: this.params
      }).then(res => {
        if (res.code === '0') {
          this.tableData=res.data;
        } else {

        }
      })
    }
  }
}
</script>


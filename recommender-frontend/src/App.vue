<template>
  <div id="app">
    <el-container>
      <el-header><h1>基于用户行为分析的个性化推荐算法</h1></el-header>
      <el-main>
        <nav>
          <router-link to="/">首页</router-link>
          <router-link to="/data">数据</router-link>
        </nav>
        <router-view/>
      </el-main>
    </el-container>
  </div>
</template>
<style>

.el-header {
  color: #333;
  text-align: center;
  min-height: 10vh;

}
.router-line-active{
  color: pink;
}

nav{
  padding: 20px;
  text-align: center;
  margin: 0 auto;
}

nav a{
  font-weight: bold;
  padding: 20px;
}
.nav a.router-link-exact-active{
  background-color: orange;
  color: #fff;
}

.router-link-active {
  text-decoration: none;

}

.el-main {
  color: #333;
  text-align: center;
  min-height: 90vh;
  border: rgba(128, 128, 128, 0.5);
  border-style: inset;
}


.el-row {
  margin-bottom: 20px;

  &:last-child {
    margin-bottom: 30px;
  }
}

.el-col {
  border-radius: 4px;
}
.router-link-active {
  text-decoration: none;
  color: black;
}
a{
  text-decoration: none;
  color: black;
}
.bg-purple-dark {
  background: #99a9bf;
}

.bg-purple {
  background: #d3dce6;
}

.bg-purple-light {
  background: #e5e9f2;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>

<script>
import request from "@/utils/request.js";

export default {
  data() {
    return {
      input: '',
      radio: 3
    }
  },
  created() {
  },
  methods: {
    load() {
      request.get().then(
          res => {
            if (res.code === '0') {

            } else {

            }
          }
      )
    },
    editinput() {
      request.get("/user").then(
          res => {
            if (res.code === '0') {
              document.getElementById("test").innerHTML = JSON.stringify(res.data);
            } else {
            }
          }
      )
    }
  }
}
</script>
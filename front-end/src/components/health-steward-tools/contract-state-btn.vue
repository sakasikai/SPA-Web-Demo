<template>
  <q-btn
    :color="cltCfmColor"
    :disabled="ifDisabled"
    size="sm"
    :label="state"
    rounded
  />
</template>

<script>
export default {
  props: {
    clientName: {
      type: String,
      required: true
    },
    contractState: {
      type: Number,
      required: true
    }
  },
  data() {
    return {
      timer: null,
      model: {
        state: 0
      }
    };
  },
  computed: {
    cltCfmColor: function() {
      switch (this.model.state) {
        case 0:
          return "grey";
        case 1:
          return "green";
        case 2:
          return "red";
      }
    },
    ifDisabled: function() {
      // 只有 未定义状态 按钮不可用，其他可点
      switch (this.model.state) {
        case 0:
          return true;
        case 1:
        case 2:
          return false;
      }
    },
    state: function() {
      switch (this.model.state) {
        case 0:
          return "未知";
        case 1:
          return "成功";
        case 2:
          return "失败";
      }
    }
  },
  created() {
    this.model.state = this.contractState; // prop 传给 data

    if (this.model.cltConfirm === 0) {
      this.timer = setInterval(() => {
        // async get /{staffName}/ContractState/{clientName}
        // update this.model.state
        console.log("in timer...");

        if (this.model.state === 1 || this.model.state === 2) {
          clearInterval(this.timer);
        }
      }, 10000);
    }
  },
  destroyed() {
    if (this.timer) {
      clearInterval(this.timer);
    }
  }
};
</script>

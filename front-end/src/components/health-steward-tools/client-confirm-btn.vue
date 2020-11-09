<template>
  <div>
    <q-btn
      :color="cltCfmColor"
      :disabled="ifDisabled"
      size="sm"
      :label="state"
      rounded
    >
      <q-tooltip content-class="bg-grey" :delay="300"
        >等待客户进行选择</q-tooltip
      >
    </q-btn>
  </div>
</template>

<script>
export default {
  props: {
    clientName: {
      type: String,
      required: true
    },
    clientConfirm: {
      type: Number,
      required: true
    }
  },
  data() {
    return {
      timer: null,
      model: {
        cltConfirm: 0
      }
    };
  },
  computed: {
    cltCfmColor: function() {
      switch (this.model.cltConfirm) {
        case 0:
          return "grey";
        case 1:
          return "green";
        case 2:
          return "red";
      }
    },
    ifDisabled: function() {
      switch (this.model.cltConfirm) {
        case 0:
          return false;
        case 1:
        case 2:
          return true;
      }
    },
    state: function() {
      switch (this.model.cltConfirm) {
        case 0:
          return "未定义";
        case 1:
          return "已确定";
        case 2:
          return "已拒绝";
      }
    }
  },
  created() {
    // clientConfirm 为0时，需要刷新请求(5s/person) 直到检测到客户做出选择，ended为true,

    this.model.cltConfirm = this.clientConfirm; // prop 传给 data

    if (this.model.cltConfirm === 0) {
      this.timer = setInterval(() => {
        // async get /{staffName}/clientConfirm/{clientName}
        // update this.state
        // this.model.cltConfirm = 1;
        console.log("in timer...");

        if (this.model.cltConfirm === 1 || this.model.cltConfirm === 2) {
          clearInterval(this.timer);
        }
      }, 30000);
    }
  },
  destroyed() {
    if (this.timer) {
      clearInterval(this.timer);
    }
  }
};
</script>

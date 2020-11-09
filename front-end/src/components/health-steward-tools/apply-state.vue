<template>
  <!-- 自动刷新的状态按钮，有1:可以申请 0:不可申请两态, 前者可点击，后者不可以-->
  <q-btn
    :color="cltCfmColor"
    size="sm"
    :label="labelMsg"
    :disabled="ifDisabled"
    rounded
  >
    <q-tooltip content-class="bg-grey" :delay="300" v-if="onHint">
      "该客户已有医生服务"
    </q-tooltip>
  </q-btn>
</template>

<script>
export default {
  props: {
    userName: {
      type: String,
      required: true
    },
    applyState: {
      type: Number,
      required: true
    }
  },
  data() {
    return {
      timer: null,
      applyLevel: 0
    };
  },
  computed: {
    cltCfmColor: function() {
      switch (this.state) {
        case 1:
          return "green";
        case 0:
          return "grey";
      }
    },
    labelMsg: function() {
      switch (this.state) {
        case 1:
          return "可以申请";
        case 0:
          return "不可申请";
      }
    },
    ifDisabled: function() {
      switch (this.state) {
        case 1:
          return false;
        case 0:
          return true;
      }
    },
    state: function() {
      switch (this.applyLevel) {
        case 2:
          return 1;
        case 3:
        case 4:
        case 5:
          return 0;
        default:
          return 0;
      }
    },
    onHint: function() {
      switch (this.state) {
        case 1:
          return false;
        case 0:
          return true;
      }
    }
  },
  created() {
    this.applyLevel = this.applyState;

    if (this.state === 1) {
      // 间断测试状态，
      this.timer = setInterval(() => {
        // async get /{staffName}/ApplyState/{clientName}
        // update this.applyLevel
        console.log("in timer...");

        if (this.state === 0) {
          clearInterval(this.timer);
        }
      }, 10000);
    } else if (this.state === 0) {
      // 不可申请
    } else {
      console.log("err");
    }
  },
  destroyed() {
    if (this.timer) {
      clearInterval(this.timer);
    }
  }
};
</script>

<template>
  <!-- 按完变状态，有通知 -->
  <div>
    <q-btn-dropdown
      flat
      color="primary"
      :label="state"
      dropdown-icon="change_history"
      v-if="!ended"
    >
      <q-list>
        <q-item clickable v-close-popup @click="StfCfmClick(1)">
          <q-item-section>
            <q-item-label>确定</q-item-label>
          </q-item-section>
        </q-item>

        <q-item clickable v-close-popup @click="StfCfmClick(2)">
          <q-item-section>
            <q-item-label>拒绝</q-item-label>
          </q-item-section>
        </q-item>
      </q-list>
    </q-btn-dropdown>
    <q-btn
      :color="stfCfmColor"
      disabled
      size="sm"
      :label="state"
      rounded
      v-else
    />
  </div>
</template>
<script>
export default {
  props: {
    clientName: {
      type: String,
      required: true
    },
    staffConfirm: {
      type: Number,
      required: true
    }
  },
  data() {
    return {
      model: {
        stfConfirm: this.staffConfirm
      }
    };
  },
  computed: {
    stfCfmColor: function() {
      switch (this.state) {
        case "已确定":
          return "green";
        case "已拒绝":
          return "red";
      }
    },
    state: function() {
      switch (this.model.stfConfirm) {
        case 0:
          return "待选择";
        case 1:
          return "已确定";
        case 2:
          return "已拒绝";
      }
    },
    ended: function() {
      // stfConfirm为1/2时，代表出结果确定，这相当于一个标志
      switch (this.model.stfConfirm) {
        case 0:
          return false;
        case 1:
        case 2:
          return true;
      }
    }
  },
  methods: {
    StfCfmClick(num) {
      if (num === 1 || num === 2) {
        // async put /{staffName}/contractConfrim/{clientName}?option=12 -> OK.
        // backend, save option
        this.model.stfConfirm = num;
      }
    }
  },
  created() {
    //   this.stfConfirm = this.staffConfirm;
    // async get /{ended/{clientName}
    // async get /{staffName}/contractConfrim/{clientName}?option=12 -> OK.
    // ended 和 state 要同步
  }
};
</script>

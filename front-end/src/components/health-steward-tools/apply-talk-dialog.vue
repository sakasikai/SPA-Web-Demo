<template>
  <q-dialog v-model="middleValue">
    <q-card>
      <q-card-section>
        <div class="row justify-between">
          <div class="text-h6">Alert</div>
          <q-btn color="red" round size="sm" icon="close" @click="close" />
        </div>
      </q-card-section>
      <q-separator />
      <q-card-section class="q-pt-md">
        这里应该有 q.notify 的反馈，因为后端api是transaction的，失败会回滚
      </q-card-section>

      <q-card-actions align="right" class="q-pa-md">
        <q-btn
          color="primary"
          dense
          label="申请洽谈"
          @click="createApplyTalk"
          :loading="onSubmitLoading"
        >
          <template v-slot:loading>
            <q-spinner-hourglass class="on-left" />
            请等待...
          </template>
        </q-btn>
      </q-card-actions>
    </q-card>
  </q-dialog>
</template>

<script>
export default {
  props: {
    myOnApplyTalkDialog: {
      type: Boolean,
      required: true
    },

    userName: {
      type: String,
      required: true
    }
  },
  computed: {
    middleValue: {
      get: function() {
        return this.myOnApplyTalkDialog;
      },
      set: function(newValue) {
        return newValue;
      }
    }
  },
  data() {
    return {
      onSubmitLoading: false
    };
  },
  methods: {
    createApplyTalk() {
      this.onSubmitLoading = true;
      // async {staffName}{userName} ApplyTalkCreation

      setTimeout(() => {
        this.onSubmitLoading = false;
        this.$q.notify({
          message: "创建成功哦",
          color: "green",
          position: "top"
        });
        this.close();
      }, 2000);
    },
    close() {
      this.$emit("myCloseApplyTalkDialog");
    }
  }
};
</script>

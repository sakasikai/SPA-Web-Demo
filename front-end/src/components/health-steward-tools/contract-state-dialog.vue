<template>
  <q-dialog v-model="middleValue">
    <q-card>
      <q-card-section>
        <div class="text-h6">Alert</div>
      </q-card-section>

      <q-card-section class="q-pt-none">
        notify of the state
      </q-card-section>

      <q-card-actions align="right">
        <q-btn
          flat
          label="删除该管理项"
          color="primary"
          @click="deleteItem(clientName)"
        />
        <q-btn flat round dense icon="close" @click="close" />
      </q-card-actions>
    </q-card>
  </q-dialog>
</template>

<script>
export default {
  props: {
    myOnContractDialog: {
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
        return this.myOnContractDialog;
      },
      set: function(newValue) {
        return newValue;
      }
    }
  },
  data() {
    return {};
  },
  methods: {
    getDetail(userName) {
      // get {staffName} {userName} notify of state
    },
    deleteItem(userName) {
      // delete item
    },
    close() {
      this.$emit("myCloseContractDialog");
    }
  }
};
</script>

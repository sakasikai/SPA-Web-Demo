<template>
  <div class=" q-pa-md">
    <q-dialog v-model="middleValue" persistent>
      <q-card>
        <q-card-section class="row items-center">
          <q-avatar icon="signal_wifi_off" color="primary" text-color="white" />
          <span class="q-ml-md">解除与{{ userName }}的合约</span>
        </q-card-section>

        <q-card-section class="row items-center">
          <q-toggle v-model="repealEnabled" label="确保完成线下程序" />
        </q-card-section>

        <!-- Notice v-close-popup -->
        <q-card-actions align="right">
          <q-btn
            flat
            color="red"
            label="解约"
            @click="repealContract"
            :disable="!repealEnabled"
          />
          <q-btn flat label="放弃" color="primary" @click="close" />
        </q-card-actions>
      </q-card>
    </q-dialog>
  </div>
</template>

<script>
export default {
  props: {
    myOnRepealContract: {
      type: Boolean,
      required: true
    },
    userName: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      repealEnabled: false
    };
  },
  computed: {
    middleValue: {
      get: function() {
        return this.myOnRepealContract;
      },
      set: function(newValue) {
        return newValue;
      }
    }
  },
  methods: {
    repealContract() {
      console.log("contract with client" + this.userName + " repealed");
      this.close();
      this.repealEnabled = false;
    },
    close() {
      this.$emit("myCloseContractPannel");
    }
  }
};
</script>

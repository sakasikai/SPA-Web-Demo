<template>
  <q-dialog v-model="middleValue">
    <q-card>
      <q-toolbar>
        <q-avatar>
          <img src="https://cdn.quasar.dev/img/avatar4.jpg" />
        </q-avatar>

        <q-toolbar-title
          ><span class="text-weight-bold">{{
            detailsModel.userName
          }}</span></q-toolbar-title
        >
        <q-btn flat round dense icon="close" @click="close" />
      </q-toolbar>

      <q-card-section>
        我叫：{{ detailsModel.nickName }} <br />
        我是工具人<br />
        Lorem ipsum dolor sit amet consectetur, adipisicing elit. Tenetur
        inventore soluta iusto eaque. Suscipit, consequuntur. Quos alias,
        dolorem commodi, illo ex perferendis optio possimus sit ipsa, modi
        eligendi deleniti recusandae?
      </q-card-section>
    </q-card>
  </q-dialog>
</template>

<script>
export default {
  props: {
    myOnDetailsPannel: {
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
      detailsModel: {
        userName: null,
        nickName: null
      }
      //   middleValue: this.myOnDetailsPannel
    };
  },
  computed: {
    middleValue: {
      get: function() {
        return this.myOnDetailsPannel;
      },
      set: function(newValue) {
        return newValue;
      }
    }
  },
  watch: {
    userName: function(val, oldVal) {
      // async get "/clientInfo"
      this.detailsModel = {
        userName: val,
        nickName: "default nickName"
        // 详细信息还有很多字段，从async get里找！
      };
    }
  },
  methods: {
    close() {
      this.$emit("myCloseDetailsPannel");
    }
  }
};
</script>

<template>
  <div>
    <q-dialog v-model="middleValue">
      <q-card>
        <q-card-section>
          <q-toolbar>
            <q-avatar>
              <img src="https://cdn.quasar.dev/img/avatar5.jpg" />
            </q-avatar>

            <q-toolbar-title
              ><span class="text-weight-bold"
                >{{ staffNoteModel.staffName }}'s note for client
                {{ staffNoteModel.userName }}</span
              ></q-toolbar-title
            >
            <q-btn flat round dense icon="close" @click="closeNote" />
          </q-toolbar>
        </q-card-section>

        <q-separator />

        <!-- 交叉备注列表 -->
        <q-card-section style="max-height: 50vh" class="scroll">
          <div class="q-pa-md flex justify-center">
            <div style="max-width: 90%; width: 400px;">
              <q-intersection
                v-for="index in 20"
                :key="index"
                transition="flip-right"
                class="staffNote"
              >
                <div class="row justify-start ">
                  <q-item clickable v-ripple>
                    <q-item-section avatar>
                      <q-avatar color="primary" text-color="white">
                        stf
                      </q-avatar>
                    </q-item-section>

                    <q-item-section>
                      <q-item-label>CustomNoteName #{{ index }}</q-item-label>
                      <q-item-label caption lines="1"
                        >{{ staffNoteModel.userName }}/{{
                          staffNoteModel.userNickName
                        }}</q-item-label
                      >
                    </q-item-section>
                    <span class="q-px-xl" />
                    <q-item-section side>
                      <q-icon
                        name="chat_bubble"
                        color="green"
                        @click="spercificNote = true"
                        class="q-px-md"
                      />
                    </q-item-section>
                  </q-item>
                </div>
              </q-intersection>
            </div>
          </div>
        </q-card-section>

        <q-card-section class="row justify-end ">
          <q-btn
            flat
            round
            dense
            icon="add"
            color="purple"
            class="q-mr-sm"
            @click="onAddNote = true"
          />
        </q-card-section>
      </q-card>
    </q-dialog>

    <!-- display item -->
    <q-dialog
      v-model="spercificNote"
      persistent
      transition-show="scale"
      transition-hide="scale"
    >
      <q-card class="bg-teal text-white" style="width: 300px">
        <q-card-section>
          <div class="text-h6">note title</div>
        </q-card-section>

        <q-card-section class="q-pt-none">
          content of note
        </q-card-section>

        <q-card-actions align="right" class="bg-white text-teal">
          <q-btn flat label="edit" />
          <q-btn flat label="delete" />
          <q-btn flat label="close" @click="closeSpecificNote" />
        </q-card-actions>
      </q-card>
    </q-dialog>

    <!-- add item -->
    <q-dialog
      v-model="onAddNote"
      persistent
      transition-show="scale"
      transition-hide="scale"
    >
      <q-card class="bg-teal text-white" style="width: 300px">
        <q-card-section>
          <div class="text-h6">note title</div>
        </q-card-section>

        <q-card-section class="q-pt-none">
          content of note
        </q-card-section>

        <q-card-actions align="right" class="bg-white text-teal">
          <q-btn flat label="close" @click="closeAddNote" />
        </q-card-actions>
      </q-card>
    </q-dialog>
  </div>
</template>

<script>
import { http } from "boot/axios.js";

export default {
  props: {
    myOnStaffNote: {
      type: Boolean,
      required: true
    },
    userName: {
      // 2 situations: staff-user-note, staff-note(default)
      type: String,
      required: false
    },
    type: {
      // 2 types: talking note, signed note
      type: String,
      required: true
    }
  },
  data() {
    return {
      staffNoteModel: {
        staffName: null,
        userName: null
      },
      spercificNote: false,
      onAddNote: false
    };
  },
  computed: {
    middleValue: {
      get: function() {
        return this.myOnStaffNote;
      },
      set: function(newValue) {
        return newValue;
      }
    }
  },
  watch: {
    userName: function(val, oldVal) {
      var url = "";
      switch (this.type) {
        case "talkingNote":
          url =
            "/api/" +
            localStorage.getItem("userName") +
            "/HealthSteward/StaffNote" +
            (val != "" ? "?clientName=" + val : "");
          break;
        case "signedNote":
          break;
        default:
      }

      this.$http
        .get(url)
        .then(res => {
          console.log(res);
        })
        .catch(err => {
          console.log(err);
        });

      this.staffNoteModel = {
        staffName: this.$store.state.user.userName
          ? this.$store.state.user.userName
          : "default staff",
        userName: val != "" ? val : "all users"
      };
    }
  },
  methods: {
    closeSpecificNote() {
      this.spercificNote = false;
    },
    closeNote() {
      this.$emit("myCloseStaffNote");
    },
    closeAddNote() {
      // do sth
      this.onAddNote = false;
    }
  }
};
</script>

<style>
.staffNote {
  height: 56px;
}
</style>

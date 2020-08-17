<template>
  <div>
    <v-card class="mx-auto" @dblclick="onDblClick">
      <v-container>
        <v-row>
          <v-col cols="2">
            <v-checkbox class="checkbox" v-model="checked" @click="onCheck"></v-checkbox>
          </v-col>
          <v-col cols="10" class="center" @dblclick="onDblClick">
            {{
            title
            }}
          </v-col>
        </v-row>
        <div
          :class="'text-right' + (limitOver ? ' text-red' : '')"
          v-if="limitDateTime"
        >{{ limitDateTime }}</div>
      </v-container>
    </v-card>
    <v-dialog v-model="dialog" persistent max-width="600px">
      <Modify :id="parentId" :close="() => (dialog = false)" :propform="propform" />
    </v-dialog>
  </div>
</template>

<script>
import { postData, TODO_SELECT, TODO_UPDATE } from "../common/API";
import Modify from "./Modify";
import moment from "moment";
import { MUTATION_KEYS } from "../store";
/**
 * TODOコンポーネント
 * @prop {number} id TODOID
 * @prop {bool} done 実施状況
 * @prop {Date} limitDateTime 期限
 * @prop {number} parentId リストID
 */
export default {
  name: "Todo",
  props: {
    todoId: Number,
    title: String,
    done: Boolean,
    limitDateTime: Date,
    parentId: Number,
  },
  components: { Modify },
  data() {
    return {
      checked: this.done,
      dialog: false,
      propform: {},
    };
  },
  computed: {
    limitOver() {
      //実施期限を過ぎているか
      if (!this.limitDateTime || this.checked) {
        return false;
      }
      const limit = moment(this.limitDateTime);
      const now = moment();

      return now.isAfter(limit);
    },
  },
  methods: {
    async onCheck() {
      //実施状況更新
      const lists = await postData(TODO_UPDATE, {
        todoId: this.todoId,
        done: this.checked,
      });
      this.$store.commit(MUTATION_KEYS.SET_LISTS, lists);
    },
    async onDblClick() {
      //詳細取得・ダイアログ表示
      const a = await postData(TODO_SELECT, { todoId: this.todoId });
      this.propform = a;
      this.dialog = true;
    },
  },
};
</script>

<style scoped>
.checkbox div {
  padding: 0;
}
.center {
  margin: auto;
}
.text-right {
  text-align: right;
}
.text-red {
  color: red;
}
</style>

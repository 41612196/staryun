CREATE TABLE ?  (
  `file_id` int(16) NOT NULL,
  `course_id` int(8) NOT NULL,
  `class_id` int(4) NOT NULL,
  `temporary_file` longblob NULL,
  PRIMARY KEY (`file_id`) USING BTREE,
  FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


CREATE TABLE ?  (
  `key_point_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` int(8) NOT NULL,
  `key_point_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`key_point_id`) USING BTREE,
  FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



CREATE TABLE ?  (
  `exercise` longblob NULL,
  `key_point_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `exercise_id` int(8) NOT NULL,
  `kind` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `answer` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `analysis` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`exercise_id`) USING BTREE,
  FOREIGN KEY (`key_point_id`) REFERENCES @ (`key_point_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


CREATE TABLE ?  (
  `course_id` int(8) NOT NULL,
  `file` longblob NOT NULL,
  `desc` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `file_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `file_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `file_suffix` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`file_id`) USING BTREE,
  FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


CREATE TABLE ?  (
  `course_id` int(8) NOT NULL,
  `class_id` int(4) NOT NULL,
  `work_id` int(8) NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `submit_time` timestamp(0) NOT NULL,
  PRIMARY KEY (`work_id`) USING BTREE,
  FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;




CREATE TABLE ?  (
  `work_id` int(8) NOT NULL,
  `exercise_id` int(8) NOT NULL,
  PRIMARY KEY (`work_id`, `exercise_id`) USING BTREE,
  FOREIGN KEY (`work_id`) REFERENCES $ (`work_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


CREATE TABLE ?  (
  `student_id` int(8) NOT NULL,
  `course_id` int(8) NOT NULL,
  `work_id` int(8) NOT NULL,
  `answer` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `exercise_id` int(8) NOT NULL,
  PRIMARY KEY (`student_id`, `course_id`, `work_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


CREATE TABLE ?  (
  `work_id` int(8) NOT NULL,
  `student_id` int(8) NOT NULL,
  `grade` int(3) NULL DEFAULT NULL,
  PRIMARY KEY (`work_id`, `student_id`) USING BTREE,
  FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (`work_id`) REFERENCES $ (`work_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
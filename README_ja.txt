    KtaiQuiz

    Copyright (C) 2011 Koichi TAKAGI <takagiko.git (atmark) gmail.com>

���̃v���O�����̓t���[�\�t�g�E�F�A�ł��B���Ȃ��͂�����A�t���[�\�t�g�E�F�A���c�ɂ���Ĕ��s���ꂽGNU��ʌ��O���p������(�o�[�W����3���A����ȍ~�̃o�[�W�����̂����ǂꂩ)����߂�����̉��ōĔЕz�܂��͉��ς��邱�Ƃ��ł��܂��B

���̃v���O�����͗L�p�ł��邱�Ƃ�����ĔЕz����܂����A*�S���̖��ۏ�* �ł��B���Ɖ\���̕ۏ؂����ړI�ւ̓K�����́A���O�Ɏ����ꂽ���̂��܂߁A�S�����݂��܂���B�ڂ�����GNU��ʌ��O���p���������������������B

���Ȃ��͂��̃v���O�����Ƌ��ɁAGNU��ʌ��O���p�������̃R�s�[���󂯎���Ă���͂��ł�(gpl-3.0.txt)�B�����󂯎���Ă��Ȃ���΁A<http://www.gnu.org/licenses/> ���������������B 


���̃v���O�����́ATomcat�̂悤��Java�A�v���P�[�V�����T�[�o��Ŏ��s�����T�[�o�T�C�h�v���O�����ł��B���́A���̃v���O������ Amazon web service (Linux 32bit)��� Java 6 �� Tomcat 7.0.6 �œ��삳���Ă��܂����B

GitHub https://github.com/takagiko/KtaiQuiz �Ń\�[�X�R�[�h�����J���Ă��܂��B


�y�ǂ̂悤�ȃv���O�����ł����H�z

�p�[�e�B�Ȃǂ̎Q���҂ɁA�i��Ɍg�ѓd�b�Łj�N�C�Y�����{���邽�߂̃V�X�e���ł��B
���̃N�C�Y�̎��{�ҁi�Ǘ��ҁj���A���Ȃ�V�X�e���ɏڂ����i�����ŃT�[�o��war�t�@�C�����f�v���C�ł���j���Ƃ�z�肵�Ă��܂��B


�y�g�����E�O�����z

�P�Dsrc/main/resources/settings.xml ���A�o�肷����̃t�@�C���ł��B�����ҏW���Ă��������B

�Q�Dsrc/main/java/ktaiquiz/dto/ConditionDto.java �́Apublic static final String SALT ���A���ł��悢�̂œK���ȕ�����ɕύX���Ă��������B

�R�Dsrc/main/java/ktaiquiz/action/DownloadURLAction.java �́Apublic static final String URL ���A���[�U�E�Ǘ��҂��A�N�Z�X����Ƃ���URL�ɕύX���Ă��������B

�S�D�T�[�o�Ƀf�v���C������Ahttp://(�T�[�o�̃A�h���X)/downloadURL/ �ɃA�N�Z�X���āA���[�U�E�Ǘ��҂��A�N�Z�X����Ƃ���URL�ꗗ���擾���Ă��������B

�T�Dsrc/main/java/ktaiquiz/action/DownloadURLAction.java �������āi�������͓K���Ƀ��l�[�����āj�A�ēx�f�v���C�������Ă��������B�S�D�̕��@��URL�ꗗ���擾�ł��Ȃ��Ȃ�܂��B

�U�D�S�D�Ń_�E�����[�h�����e�L�X�g�t�@�C���̂Q�s�ڈȍ~���A���[�U�pURL�ł��B�������Ȃǂ��ă��[�U�ɔz�z���鏀�������Ă��������B


�y�g�����E�����z

�P�D�O�����̂U�ŏ�������URL�����[�U�ɔz�z���Ă��������B

�Q�D�Ǘ��җpURL�i�S�D�Ń_�E�����[�h�����e�L�X�g�t�@�C���̂P�s�ځj�ɃA�N�Z�X���Ă��������B

�R�D���[�U��URL�ɃA�N�Z�X���A���[�U����o�^���ď������ł�����A�Ǘ��҂��u��P��v�́u��t���ɂ���v���N���b�N����ƁA��P�₪�񓚉\�ɂȂ�܂��B
�@���Q�l�F�u���O�C�����[�U�F??�l�v�̉E�́u�ʃE�C���h�E�ňꗗ�v���N���b�N����ƁA�o�^���ς񂾃��[�U�̈ꗗ���\���ł��܂��B

�S�D�񓚂���ߐ؂�Ƃ��́A���݉񓚒��̎��̖��́u��t�O�ɂ���v���N���b�N����ƁA���݉񓚒��̖��̉񓚂����ߐ؂��܂��B
�@���Q�l�F�u�����[�h�v���N���b�N����ƁA���̎��_�ŉ񓚍ς݂̐l�����X�V����܂��B
�@���Q�l�F�u�ʃE�C���h�E�ŃO���t�\���v���N���b�N����ƁA�񓚂̕��z���O���t�ŕ\������܂��B���̑���͉񓚒��؂�O�ł��A���؂��ł��\�ł��B

�T�D�Ō�̖��̉𓚂���ߐ؂�Ƃ��́A�u��t�I����Ԃɂ���v���N���b�N���܂��B

�U�D�u�ʃE�C���h�E�Ō��ʔ��\�v���N���b�N����ƁA�P�D���_���@�Q�D�񓚂ɗv�������ώ��ԏ��@�ŏ��ʂ��\������܂��B
�@���v���W�F�N�^�ȂǂŎQ���҂Ɍ������ԂŔ��\����Ɛ���オ��܂����AURL�Ɋ܂܂�郆�[�U���ƃn�b�V���݂̂ŔF�؂��Ă���̂ŁA�Q���҂���Ǘ��҉�ʂ�URL�������Ȃ��悤�ɂ��Ă��������B


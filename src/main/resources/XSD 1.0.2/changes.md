1. Добавлены в RFPEPGURequest теги filePhotoType, OptionalMarksType, TempoCertRequestType
2. Добавлен тег CancelResponse в RFPEPGUResponseType
3. В RFPEPGUResponse возвращается лишь один тип ответа из возможных (TextMessageResponseType/TextMessageAnswerType/CancelResponseType)
4. Основания для замены - изменены ограничения. Основная причина (max=1, min=1), дополнительная причина (max=1, min=0)
5. Добавлен ZNBirthCertificate в запрос на выдачу паспорта (в newPersData его быть не должно)
6. additionalReason изменен тип на string
7. Незначительные правки описания